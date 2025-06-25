package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileResponseEntity

interface UserRepository {
    suspend fun delete(): ServiceResult<Unit>
    suspend fun updateProfile(updateProfile: UpdateProfileRequestEntity): ServiceResult<UpdateProfileResponseEntity>
    suspend fun isValidToken(hasToken: Boolean): ServiceResult<GetProfileResponseEntity>
    suspend fun isHasToken(): Boolean
    suspend fun getProfile(): ServiceResult<GetProfileResponseEntity>
}