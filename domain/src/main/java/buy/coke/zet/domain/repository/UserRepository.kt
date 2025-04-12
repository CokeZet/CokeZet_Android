package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult

interface UserRepository {
    suspend fun delete(): ServiceResult<Unit>
}