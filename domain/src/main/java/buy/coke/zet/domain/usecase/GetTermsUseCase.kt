package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.contents.GetTermsResponseEntity
import buy.coke.zet.domain.repository.ContentsRepository
import javax.inject.Inject

/** 이용약관 조회 유스케이스
 * 사용자의 이용약관 조회 유스케이스 입니다.
 * GetTermsResponseEntity 예시
 * title = 이용약관
 * content = 이용약관 내용
 * updatedAt = 이용약관이 업데이트된 날짜
 */

class GetTermsUseCase @Inject constructor(
    private val contentsRepository: ContentsRepository
) {
    suspend operator fun invoke(): ServiceResult<GetTermsResponseEntity> {
        return contentsRepository.getTerms()
    }
}