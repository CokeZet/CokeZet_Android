package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileResponseEntity
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

/** 사용자 프로필 업데이트 유스케이스
 * UpdateProfileRequestEntity의
 * nickname = 사용자 닉네임
 * commerceIds = 쇼핑몰 아이디
 * 각 아이디는 백엔드에서 정의하면 카톡 또는 해당 주석에 다시 달아놓겠습니다.
 * 테스트용으로 commerceIds = 1 하시면 테스트 가능하십니다.
 *
 * notificationEnabled, receiveNotificationAfter8PM, fcmToken
 * 위 객체들은 아마, FCM에 쓰일것같습니다. 아직 쓰임새는 없습니다.
 */

class UpdateProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(updateProfile: UpdateProfileRequestEntity): ServiceResult<UpdateProfileResponseEntity> {
        return userRepository.updateProfile(updateProfile)
    }
}