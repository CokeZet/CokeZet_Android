package buy.coke.zet.data.datasource

import buy.coke.zet.data.dto.login.LoginRequestDto
import buy.coke.zet.data.dto.refresh.RefreshRequestDto
import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.data.dto.refresh.RefreshResponseDto
import buy.coke.zet.data.api.AuthApiService
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.data.errorhandle.safeApiCallAllowingNull
import buy.coke.zet.data.mapper.mapToUnit
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface AuthDataSource {
    suspend fun login(loginRequestDto: LoginRequestDto): ServiceResult<LoginResponseDto>
    suspend fun getLogin(): ServiceResult<LoginResponseDto>
    suspend fun refreshToken(refreshToken: String): ServiceResult<RefreshResponseDto>
    suspend fun logout(): ServiceResult<Unit>
}

class AuthDataSourceImpl @Inject constructor(
    private val apiService: AuthApiService
) : AuthDataSource {
    override suspend fun login(loginRequestDto: LoginRequestDto): ServiceResult<LoginResponseDto> {
        return safeApiCall { apiService.login(loginRequestDto) }
    }

    override suspend fun getLogin(): ServiceResult<LoginResponseDto> {
        return safeApiCall { apiService.getLogin() }
    }

    override suspend fun refreshToken(refreshToken: String): ServiceResult<RefreshResponseDto> {
        return safeApiCall { apiService.refresh(RefreshRequestDto(refreshToken)) }
    }

    override suspend fun logout(): ServiceResult<Unit> {
        return safeApiCallAllowingNull { apiService.logout() }.mapToUnit()
    }
}