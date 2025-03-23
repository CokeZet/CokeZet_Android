package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.repository.AuthRepository
import javax.inject.Inject

class IsHasTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Boolean {
        return authRepository.isHasToken()
    }
}