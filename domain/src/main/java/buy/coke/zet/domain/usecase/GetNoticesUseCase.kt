package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.contents.GetNoticeResponseEntity
import buy.coke.zet.domain.repository.ContentsRepository
import javax.inject.Inject

/** 공지사항 목록 조회 유스케이스
 * GetNoticeResponseEntity 의
 * title = 공지사항 제목
 * content = 공지사항 내용
 * createdAt = 공지사항 게시 날짜
 * important 해당 공지사항의 중요도
 * 서버에서 important는 혹시몰라 추가 하셨다 했습니다., 굳이 신경 쓰지 않으셔도 될듯합니다.
 */
class GetNoticesUseCase @Inject constructor(
    private val contentsRepository: ContentsRepository
) {
    suspend operator fun invoke(): ServiceResult<List<GetNoticeResponseEntity>> {
        return contentsRepository.getNotices()
    }
}