package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity

interface AuthRepository {
    suspend fun loginWithGoogle(): ServiceResult<LoginResponseEntity>
}