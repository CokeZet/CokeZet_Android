package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.contents.GetPrivacyPolicyResponseEntity
import buy.coke.zet.domain.repository.ContentsRepository
import javax.inject.Inject

/** 사용자 개인정보 처리방침 유스케이스
 * GetPrivacyPolicyResponseEntity 의 응답값
 * title = 개인정보처리방침
 * content = 이용약관 내용
 * updatedAt = 이용약관이 업데이트된 날짜
 * 5월 8일기준 아직 이용약관 이 서버에 등록되지않아 Error로 표시됩니다.
 * 참고 해주세요!
 */

class GetPrivacyPolicyUseCase @Inject constructor(
    private val contentsRepository: ContentsRepository
) {
    suspend operator fun invoke(): ServiceResult<GetPrivacyPolicyResponseEntity> {
        return contentsRepository.getPrivacyPolicy()
    }
}