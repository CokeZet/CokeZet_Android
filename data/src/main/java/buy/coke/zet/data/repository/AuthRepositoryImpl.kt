package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.dto.login.LoginRequestDto
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
        if (!hasToken) {
            return ServiceResult.Error("NOT_HAVE_TOKEN", "저장된 토큰이 없습니다.")
        }

        val firstResult = authDataSource.getLogin()

        if (firstResult is ServiceResult.Success) {
            tokenManager.saveTokens(
                firstResult.data.accessToken,
                firstResult.data.refreshToken
            )
            return ServiceResult.Success(firstResult.data.toEntity())
        }

        if (firstResult is ServiceResult.Error && firstResult.code == "AUTH-003") {
            val secondResult = authDataSource.getLogin()

            return when (secondResult) {
                is ServiceResult.Success -> {
                    tokenManager.saveTokens(
                        secondResult.data.accessToken,
                        secondResult.data.refreshToken
                    )
                    ServiceResult.Success(secondResult.data.toEntity())
                }

                is ServiceResult.Error -> ServiceResult.Error(secondResult.code, secondResult.message)
                is ServiceResult.NetworkError -> ServiceResult.NetworkError
            }
        }

        // 401이 아니거나 재시도 안될때 동작 ( 토큰이 비어있는 상황 등등 )
        return when (firstResult) {
            is ServiceResult.Error -> {
                ServiceResult.Error(firstResult.code, firstResult.message)
            }
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
            else -> ServiceResult.Error("UNKNOWN", "알 수 없는 오류 발생")
        }
    }

    override suspend fun isHasToken(): Boolean {
        return tokenManager.isHasToken()
    }


    companion object {
        private const val AUTH_PROVIDER_GOOGLE = "GOOGLE"
    }
}