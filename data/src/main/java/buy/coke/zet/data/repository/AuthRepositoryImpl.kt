package buy.coke.zet.data.repository

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

        val serverResult = authDataSource.login(LoginRequestDto(idToken, AUTH_PROVIDER_GOOGLE))

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

    override suspend fun isValidToken(hasToken: Boolean): ServiceResult<LoginResponseEntity> {
        if (hasToken) {
            val serverResult = authDataSource.getLogin()

            return when (serverResult) {
                is ServiceResult.Success -> ServiceResult.Success(serverResult.data.toEntity())
                is ServiceResult.Error -> ServiceResult.Error(serverResult.code, serverResult.message)
                is ServiceResult.NetworkError -> ServiceResult.NetworkError
            }
        } else {
            return ServiceResult.Error("NOT HAVE TOKEN", "저장 되어 있는 토큰이 없습니다.")
        }
    }

    override suspend fun isHasToken(): Boolean {
        return tokenManager.isHasToken()
    }


    companion object {
        private const val AUTH_PROVIDER_GOOGLE = "GOOGLE"
    }
}