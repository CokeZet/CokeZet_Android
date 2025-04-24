package buy.coke.zet.domain.repository

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity

interface PromotionRepository {
    suspend fun getStorePromotions(): ServiceResult<List<StorePromotionResponseEntity>>
}