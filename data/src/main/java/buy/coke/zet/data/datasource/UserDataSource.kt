package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.UserApiService
import buy.coke.zet.data.dto.getprofile.GetProfileResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.data.errorhandle.safeApiCallAllowingNull
import buy.coke.zet.data.mapper.mapToUnit
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface UserDataSource {
    suspend fun delete(): ServiceResult<Unit>
    suspend fun updateProfile(updateProfile: UpdateProfileRequestDto): ServiceResult<Unit>
    suspend fun getProfile(): ServiceResult<GetProfileResponseDto>
}

class UserDataSourceImpl @Inject constructor(
    private val apiService: UserApiService
) : UserDataSource {
    override suspend fun delete(): ServiceResult<Unit> {
        return safeApiCallAllowingNull { apiService.delete() }.mapToUnit()
    }

    override suspend fun updateProfile(updateProfile: UpdateProfileRequestDto): ServiceResult<Unit> {
        return safeApiCallAllowingNull { apiService.updateProfile(updateProfile) }.mapToUnit()
    }

    override suspend fun getProfile(): ServiceResult<GetProfileResponseDto> {
        return safeApiCall { apiService.getProfile() }
    }
}