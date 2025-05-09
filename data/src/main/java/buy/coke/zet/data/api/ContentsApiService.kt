package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.contents.GetNoticeResponseDto
import buy.coke.zet.data.dto.contents.GetPrivacyPolicyResponseDto
import buy.coke.zet.data.dto.contents.GetTermsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface ContentsApiService {
    @GET("/api/contents/notices")
    suspend fun getNotices(): Response<CommonResponseDto<List<GetNoticeResponseDto>>>

    @GET("api/contents/privacy-policy")
    suspend fun getPrivacyPolicy(): Response<CommonResponseDto<GetPrivacyPolicyResponseDto>>

    @GET("api/contents/terms")
    suspend fun getTerms(): Response<CommonResponseDto<GetTermsResponseDto>>
}