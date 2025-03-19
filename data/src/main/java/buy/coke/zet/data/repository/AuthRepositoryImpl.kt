package buy.coke.zet.data.repository

import android.util.Log
import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.dto.request.LoginRequestDto
import buy.coke.zet.data.local.TokenManager
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun loginWithGoogle(idToken: String): ServiceResult<LoginResponseEntity> {
        Log.d("0526GoogleResult", "idToken: $idToken")

        val serverResult = authDataSource.login(LoginRequestDto(idToken, AUTH_PROVIDER_GOOGLE))
        Log.d("0526ServerResult", serverResult.toString())

        return when (serverResult) {
            is ServiceResult.Success -> {
                tokenManager.saveTokens(
                    serverResult.data.accessToken,
                    serverResult.data.refreshToken
                )
                ServiceResult.Success(serverResult.data.toEntity())
            }

            is ServiceResult.Error -> ServiceResult.Error(serverResult.code, serverResult.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    companion object {
        private const val AUTH_PROVIDER_GOOGLE = "GOOGLE"
    }
}