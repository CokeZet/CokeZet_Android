package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.UserApiService
import buy.coke.zet.data.errorhandle.safeApiCallAllowingNull
import buy.coke.zet.data.mapper.mapToUnit
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface UserDataSource {
    suspend fun delete(): ServiceResult<Unit>
}

class UserDataSourceImpl @Inject constructor(
    private val apiService: UserApiService
) : UserDataSource {
    override suspend fun delete(): ServiceResult<Unit> {
        return safeApiCallAllowingNull { apiService.delete() }.mapToUnit()
    }
}