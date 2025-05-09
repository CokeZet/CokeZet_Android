package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity

interface UserRepository {
    suspend fun delete(): ServiceResult<Unit>
    suspend fun updateProfile(updateProfile: UpdateProfileRequestEntity): ServiceResult<Unit>
    suspend fun isValidToken(hasToken: Boolean): ServiceResult<GetProfileResponseEntity>
    suspend fun isHasToken(): Boolean
    suspend fun getProfile(): ServiceResult<GetProfileResponseEntity>
}