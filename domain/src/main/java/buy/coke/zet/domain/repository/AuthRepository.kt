package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.login.LoginResponseEntity

interface AuthRepository {
    suspend fun loginWithGoogle(idToken: String): ServiceResult<LoginResponseEntity>
    suspend fun isValidToken(hasToken: Boolean): ServiceResult<LoginResponseEntity>
    suspend fun isHasToken(): Boolean
    suspend fun logout(): ServiceResult<Unit>
}