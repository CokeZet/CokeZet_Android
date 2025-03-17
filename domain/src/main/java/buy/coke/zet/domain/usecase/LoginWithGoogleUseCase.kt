package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

/** 구글 로그인 유스케이스
 * 바로 호출 하셔서 사용 하시면 됩니다.
 * LoginResponseEntity 의 newUser 가 true 라면 사용자 프로필을 설정하는 화면,
 * LoginResponseEntity 의 newUser 가 false 라면 Home 으로 이동 시키시면 됩니다.
 * */

class LoginWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): ServiceResult<LoginResponseEntity> {
        return authRepository.loginWithGoogle()
    }
}