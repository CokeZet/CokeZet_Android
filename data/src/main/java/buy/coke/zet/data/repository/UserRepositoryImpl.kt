package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.UserDataSource
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun delete(): ServiceResult<Unit> {
        val result = userDataSource.delete()
        return when(result) {
            is ServiceResult.Success -> ServiceResult.Success(Unit)
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }
}