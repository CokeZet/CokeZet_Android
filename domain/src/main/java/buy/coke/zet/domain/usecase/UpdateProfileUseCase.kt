package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

class UpdateProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(updateProfile: UpdateProfileRequestEntity): ServiceResult<Unit> {
        return userRepository.updateProfile(updateProfile)
    }
}