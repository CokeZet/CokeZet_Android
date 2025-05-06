package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

/** 토큰 유효성 검사 유스케이스
 * Local DB에 Token이 있는지 없는지를 Boolean 값으로 내려줍니다.
 * 해당 Boolean 값을 IsValidTokenUseCase에 값을 전달 해주시면 됩니다.
 * true = Token 있음, false = Token 없음
 */

class IsHasTokenUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Boolean {
        return userRepository.isHasToken()
    }
}