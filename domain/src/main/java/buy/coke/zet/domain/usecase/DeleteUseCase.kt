package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

/** 회원탈퇴 유스케이스
 * revokeToken을 호출해 사용하시면 됩니다.
 */

class DeleteUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    suspend operator fun invoke(revokeToken: String): ServiceResult<Unit> {
        return userRepository.delete(revokeToken)
    }
}