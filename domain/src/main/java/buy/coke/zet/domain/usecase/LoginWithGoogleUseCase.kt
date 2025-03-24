package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

/** 구글 로그인 유스케이스
 * GoogleAuthManager의 getGoogleToken을 통해 받은 Token값을 UseCase에 넣어주시면 됩니다.
 * */

class LoginWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(idToken: String): ServiceResult<LoginResponseEntity> {
        return authRepository.loginWithGoogle(idToken)
    }
}