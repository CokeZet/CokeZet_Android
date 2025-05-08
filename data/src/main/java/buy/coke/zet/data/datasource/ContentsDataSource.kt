package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.ContentsApiService
import buy.coke.zet.data.dto.contents.GetNoticeResponseDto
import buy.coke.zet.data.dto.contents.GetPrivacyPolicyResponseDto
import buy.coke.zet.data.dto.contents.GetTermsResponseDto
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface ContentsDataSource {
    suspend fun getNotices(): ServiceResult<List<GetNoticeResponseDto>>
    suspend fun getPrivacyPolicy(): ServiceResult<GetPrivacyPolicyResponseDto>
    suspend fun getTerms(): ServiceResult<GetTermsResponseDto>
}

class ContentsDataSourceImpl @Inject constructor(
    private val apiService: ContentsApiService
) : ContentsDataSource {
    override suspend fun getNotices(): ServiceResult<List<GetNoticeResponseDto>> {
        return safeApiCall { apiService.getNotices() }
    }

    override suspend fun getPrivacyPolicy(): ServiceResult<GetPrivacyPolicyResponseDto> {
        return safeApiCall { apiService.getPrivacyPolicy() }
    }

    override suspend fun getTerms(): ServiceResult<GetTermsResponseDto> {
        return safeApiCall { apiService.getTerms() }
    }
}