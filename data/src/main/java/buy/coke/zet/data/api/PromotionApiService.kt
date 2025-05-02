package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.promotions.PromotionResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Query가 null이면 현재 시간 기준 크롤링 데이터를 넘겨줌
// Query의 year과 month 값에 따라 그 시간 기준 크롤링 데이터를 넘겨줌
// 한 달 마다 데이터가 업데이트가 됨
interface PromotionApiService {
    @GET("/api/promotions")
    suspend fun getPromotions(
        @Query("year") year: Int? = null,
        @Query("month") month: Int? = null
    ): Response<CommonResponseDto<PromotionResponseDto>>
}