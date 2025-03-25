package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

/** 토큰 유효성에 따른 자동 로그인 유스케이스
 * IsHasTokenUseCase의 Boolean 값을 해당 UseCase에 넣어주시면 됩니다.
 * 자동 로그인이 실패하면 로그아웃을 시키고 로그인화면으로 이동 시켜주시면 되겠습니다.
 * ( 2025. 03 .26 기준 아직 로그아웃 유스케이스 없음 )
 */

class IsValidTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(hasToken: Boolean): ServiceResult<LoginResponseEntity> {
        return authRepository.isValidToken(hasToken)
    }
}