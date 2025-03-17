package buy.coke.zet.data.datasource

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import buy.coke.zet.data.model.GoogleAuthModel
import buy.coke.zet.data.util.Constants
import buy.coke.zet.domain.ServiceResult
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import dagger.hilt.android.qualifiers.ApplicationContext
import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject

interface GoogleAuthDataSource {
    suspend fun loginWithGoogle(): ServiceResult<GoogleAuthModel>
}

class GoogleAuthDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val credentialManager: CredentialManager
) : GoogleAuthDataSource {
    override suspend fun loginWithGoogle(): ServiceResult<GoogleAuthModel> {
        return try {
            val rawNonce = UUID.randomUUID().toString()
            val hashedNonce = hashNonce(rawNonce)

            val googleIdOption = GetGoogleIdOption.Builder()
                .setServerClientId(Constants.GOOGLE_CLIENT_ID)
                .setFilterByAuthorizedAccounts(true)
                .setNonce(hashedNonce)
                .build()

            val getCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(
                request = getCredentialRequest,
                context = context
            )

            val credential = result.credential
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
            val googleIdToken = googleIdTokenCredential.idToken

            if (googleIdToken.isNotEmpty()) {
                ServiceResult.Success(GoogleAuthModel(idToken = googleIdToken))
            } else {
                ServiceResult.Error("GOOGLE_LOGIN_FAILED", "Google 로그인 실패: ID 토큰 없음")
            }
        } catch (e: Exception) {
            ServiceResult.Error("EXCEPTION", e.localizedMessage ?: "Google 로그인 실패")
        }
    }

    private fun hashNonce(nonce: String): String {
        val bytes = nonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }
}