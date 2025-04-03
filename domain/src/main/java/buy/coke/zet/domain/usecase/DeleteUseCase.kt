package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    suspend operator fun invoke(): ServiceResult<Unit> {
        return userRepository.delete()
    }
}