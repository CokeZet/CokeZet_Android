package buy.coke.zet.presentation.util

import android.app.Activity
import android.content.Intent
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import buy.coke.zet.presentation.BuildConfig
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.security.MessageDigest
import java.util.UUID

/** 구글 idToken을 받기위한 Manager
 *  getGoogleToken은 "무조건" Activity를 받아야합니다 ( context는 안됩니다. )
 *  getGoogleToken에서 받은 idToken을 LoginWithGoogleUseCase 으로 넣어주시면 됩니다.
 * */

object GoogleAuthManager {
    private const val CLIENT_ID = BuildConfig.GOOGLE_CLIENT_ID

    suspend fun getGoogleToken(activity: Activity): String? {
        val credentialManager = CredentialManager.create(activity)

        return runCatching {
            val rawNonce = UUID.randomUUID().toString()
            val hashedNonce = hashNonce(rawNonce)

            val googleSignInOption = GetSignInWithGoogleOption.Builder(CLIENT_ID)
                .setNonce(hashedNonce)
                .build()

            val getCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleSignInOption)
                .build()

            val result = credentialManager.getCredential(activity, getCredentialRequest)
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(result.credential.data)

            googleIdTokenCredential.idToken.takeIf { it.isNotEmpty() }
        }.getOrNull()
    }

    private fun hashNonce(nonce: String): String {
        return MessageDigest.getInstance("SHA-256")
            .digest(nonce.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}

/** 구글 revoke, 완전한 회원탈퇴를 위한 Manager
 * 완전한 회원탈퇴를 위해 AccessToken을 해당 메서드로 받아옵니다.
 * */

object GoogleDeleteManager {
    private const val CLIENT_ID = BuildConfig.GOOGLE_CLIENT_ID
    private const val CLIENT_SECRET = BuildConfig.GOOGLE_SECRET_PWD
    private const val REDIRECT_URI = ""

    fun getSignInIntent(activity: Activity): Intent {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestServerAuthCode(CLIENT_ID, true)
            .build()

        return GoogleSignIn.getClient(activity, gso).signInIntent
    }

    fun extractAuthCode(data: Intent?): String? {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        return try {
            task.getResult(ApiException::class.java)?.serverAuthCode
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getAccessToken(authCode: String): String? = withContext(Dispatchers.IO) {
        val url = "https://oauth2.googleapis.com/token"

        val formBody = FormBody.Builder()
            .add("code", authCode)
            .add("client_id", CLIENT_ID)
            .add("client_secret", CLIENT_SECRET)
            .add("redirect_uri", REDIRECT_URI)
            .add("grant_type", "authorization_code")
            .build()

        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()

        val client = OkHttpClient()
        val response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val body = response.body?.string()
            JSONObject(body ?: "").getString("access_token")
        } else null
    }
}