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
import javax.inject.Provider

class TokenAuthenticator @Inject constructor(
    private val authDataSource: Provider<AuthDataSource>,
    private val tokenManager: TokenManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.code != 401) return null

        val requestUrl = response.request.url.toString()
        if (requestUrl.contains("/api/auth/refresh")) {
            // refresh 만 header값 제거
            return null
        }

        return runBlocking {
            val refreshToken = tokenManager.getRefreshToken()
            if (refreshToken.isNullOrEmpty()) return@runBlocking null
            val newTokenResult = try {
                authDataSource.get().refreshToken(refreshToken)
            } catch (e: Exception) {
                tokenManager.clearTokens()
                return@runBlocking null
            }

            when (newTokenResult) {
                is ServiceResult.Success -> {
                    tokenManager.saveTokens(
                        newTokenResult.data.accessToken,
                        newTokenResult.data.refreshToken
                    )

                    response.request.newBuilder()
                        .header("Authorization", "Bearer ${newTokenResult.data.accessToken}")
                        .build()
                }

                else -> {
                    tokenManager.clearTokens()
                    null //TODO :: 로그아웃 처리 하기
                }
            }
        }
    }
}