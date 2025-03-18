package buy.coke.zet.data.network.authenticator

import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.local.TokenManager
import buy.coke.zet.domain.ServiceResult
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val authDataSource: dagger.Lazy<AuthDataSource>,
    private val tokenManager: TokenManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val accessToken = tokenManager.getAccessToken()
            val refreshToken = tokenManager.getRefreshToken()

            if (response.request.header("Authorization") == "Bearer $accessToken") {
                if (refreshToken.isNullOrEmpty()) {
                    return null // Todo :: 토큰이 없을때 처리 -> 백엔드 개발이 되면 로그아웃 처리 할것
                }

                val newTokenResult = runBlocking { authDataSource.get().refreshToken(refreshToken) }

                return when (newTokenResult) {
                    is ServiceResult.Success -> {
                        runBlocking {
                            tokenManager.saveTokens(newTokenResult.data.accessToken, newTokenResult.data.refreshToken)
                        }

                        response.request.newBuilder()
                            .header("Authorization", "Bearer ${newTokenResult.data.accessToken}")
                            .build()
                    }
                    else -> null // Todo :: RefreshToken이 없을때 처리 -> 백엔드 개발이 되면 로그아웃 처리 할것
                }
            }
            return null
        }
    }
}