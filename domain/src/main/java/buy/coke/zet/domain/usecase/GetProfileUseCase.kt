package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.repository.UserRepository
import javax.inject.Inject

/** 유저 프로필 유스케이스
 * 유저가 설정한 프로필을 조회할 수 있습니다.
 * 필요하실것 같아 추가로 만들었습니다.
 * 예시로
 * id = 1
 * email = "abc@gmail.com
 * nickname = "주코"
 * profileComplete = true ( 현재 신경쓰지 않아도 되는 프로퍼티입니다. 프로필을 완성했는지 여부를 알려줍니다. )
 * preferredCommerces [ id = 1, name = 쿠팡 ]
 * preferredCardCompanies [ id = 1, name = 농협 ]
 * 와 같은 데이터로 내려 옵니다.
 */

class GetProfileUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): ServiceResult<GetProfileResponseEntity> {
        return userRepository.getProfile()
    }
}