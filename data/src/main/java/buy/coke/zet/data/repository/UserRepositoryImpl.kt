package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.UserDataSource
import buy.coke.zet.data.dto.delete.DeleteRequestDto
import buy.coke.zet.data.local.TokenManager
import buy.coke.zet.data.mapper.toDto
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileResponseEntity
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
    private val tokenManager: TokenManager
) : UserRepository {
    override suspend fun delete(revokeToken: String): ServiceResult<Unit> {
        val result = userDataSource.delete(DeleteRequestDto(revokeToken = revokeToken, socialProvider = USER_PROVIDER_GOOGLE))
        return when(result) {
            is ServiceResult.Success -> ServiceResult.Success(Unit)
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    override suspend fun updateProfile(updateProfile: UpdateProfileRequestEntity): ServiceResult<UpdateProfileResponseEntity> {
        val result = userDataSource.updateProfile(updateProfile.toDto())
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    override suspend fun isValidToken(hasToken: Boolean): ServiceResult<GetProfileResponseEntity> {
        if (!hasToken) {
            return ServiceResult.Error("NOT_HAVE_TOKEN", "저장된 토큰 없움")
        }
        val result = userDataSource.getProfile()
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    override suspend fun isHasToken(): Boolean {
        return tokenManager.isHasToken()
    }

    override suspend fun getProfile(): ServiceResult<GetProfileResponseEntity> {
        val result = userDataSource.getProfile()
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }

    companion object {
        private const val USER_PROVIDER_GOOGLE = "GOOGLE"
    }
}