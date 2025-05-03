package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.PromotionApiService
import buy.coke.zet.data.dto.promotions.PromotionResponseDto
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface PromotionDataSource {
    suspend fun getPromotions(): ServiceResult<PromotionResponseDto>
}

class PromotionDataSourceImpl @Inject constructor(
    private val apiService: PromotionApiService
) : PromotionDataSource {
    override suspend fun getPromotions(): ServiceResult<PromotionResponseDto> {
        return safeApiCall { apiService.getPromotions() }
    }
}