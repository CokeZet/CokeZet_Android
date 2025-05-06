package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

/** 토큰 유효성에 따른 자동 로그인 유스케이스
 * IsHasTokenUseCase의 Boolean 값을 해당 UseCase에 넣어주시면 됩니다.
 * 자동 로그인이 실패하면 로그아웃을 시키고 로그인화면으로 이동 시켜주시면 되겠습니다.
 * ( 2025. 03 .30, PR 올린 날짜 기준 아직 로그아웃 유스케이스 없음 )
 */

class IsValidTokenUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(hasToken: Boolean): ServiceResult<GetProfileResponseEntity> {
        return userRepository.isValidToken(hasToken)
    }
}