package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.UserApiService
import buy.coke.zet.data.dto.delete.DeleteRequestDto
import buy.coke.zet.data.dto.getprofile.GetProfileResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileResponseDto
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.data.errorhandle.safeApiCallAllowingNull
import buy.coke.zet.data.mapper.mapToUnit
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface UserDataSource {
    suspend fun delete(request: DeleteRequestDto): ServiceResult<Unit>
    suspend fun updateProfile(updateProfile: UpdateProfileRequestDto): ServiceResult<UpdateProfileResponseDto>
    suspend fun getProfile(): ServiceResult<GetProfileResponseDto>
}

class UserDataSourceImpl @Inject constructor(
    private val apiService: UserApiService
) : UserDataSource {
    override suspend fun delete(request: DeleteRequestDto): ServiceResult<Unit> {
        return safeApiCallAllowingNull { apiService.delete(request) }.mapToUnit()
    }

    override suspend fun updateProfile(updateProfile: UpdateProfileRequestDto): ServiceResult<UpdateProfileResponseDto> {
        return safeApiCall { apiService.updateProfile(updateProfile) }
    }

    override suspend fun getProfile(): ServiceResult<GetProfileResponseDto> {
        return safeApiCall { apiService.getProfile() }
    }
}