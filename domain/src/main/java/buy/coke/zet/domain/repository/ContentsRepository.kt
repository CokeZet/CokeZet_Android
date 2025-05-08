package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.contents.GetNoticeResponseEntity
import buy.coke.zet.domain.entitiy.contents.GetPrivacyPolicyResponseEntity
import buy.coke.zet.domain.entitiy.contents.GetTermsResponseEntity

interface ContentsRepository {
    suspend fun getNotices(): ServiceResult<List<GetNoticeResponseEntity>>
    suspend fun getPrivacyPolicy(): ServiceResult<GetPrivacyPolicyResponseEntity>
    suspend fun getTerms(): ServiceResult<GetTermsResponseEntity>
}