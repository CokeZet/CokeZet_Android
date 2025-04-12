package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

/** 로그아웃 유스케이스
 * 바로 호출해서 사용하시면 됩니다.
 * */
class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): ServiceResult<Unit> {
        return authRepository.logout()
    }
}