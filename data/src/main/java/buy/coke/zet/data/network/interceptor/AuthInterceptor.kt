package buy.coke.zet.data.network.interceptor

import buy.coke.zet.data.local.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()
        val requestBuilder = request.newBuilder()

        // refresh 요청에는 Authorization 헤더를 붙이지 않도록 설정
        if (!url.contains("/api/auth/refresh")) {

            val token = runBlocking {
                tokenManager.getAccessToken()
            }

            token?.let {
                requestBuilder.addHeader("Authorization", "Bearer $it")
            }
        }
        return chain.proceed(requestBuilder.build())
    }
}