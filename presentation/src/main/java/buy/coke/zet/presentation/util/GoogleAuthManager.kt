package buy.coke.zet.presentation.util

import android.app.Activity
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import buy.coke.zet.presentation.BuildConfig
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
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
