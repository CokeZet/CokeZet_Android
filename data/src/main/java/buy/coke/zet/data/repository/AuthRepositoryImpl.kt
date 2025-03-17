package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.AuthDataSource
import buy.coke.zet.data.datasource.GoogleAuthDataSource
import buy.coke.zet.data.local.TokenManager
import buy.coke.zet.data.mapper.toDto
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val googleAuthDataSource: GoogleAuthDataSource,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun loginWithGoogle(): ServiceResult<LoginResponseEntity> {
        return when (val googleResult = googleAuthDataSource.loginWithGoogle()) {
            is ServiceResult.Success -> {
                when (val serverResult = authDataSource.login(googleResult.data.toDto())) {
                    is ServiceResult.Success -> {
                        tokenManager.saveTokens(serverResult.data.accessToken, serverResult.data.refreshToken)
                        ServiceResult.Success(serverResult.data.toEntity())
                    }
                    is ServiceResult.Error -> ServiceResult.Error(
                        serverResult.code,
                        serverResult.message
                    )
                    is ServiceResult.NetworkError -> ServiceResult.NetworkError
                }
            }
            is ServiceResult.Error -> ServiceResult.Error(googleResult.code, googleResult.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }
}