package buy.coke.zet.data.repository

import buy.coke.zet.data.datasource.PromotionDataSource
import buy.coke.zet.data.mapper.toEntityList
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity
import buy.coke.zet.domain.repository.PromotionRepository
import javax.inject.Inject

class PromotionRepositoryImpl @Inject constructor(
    private val promotionDataSource: PromotionDataSource
) : PromotionRepository {
    override suspend fun getStorePromotions(): ServiceResult<List<StorePromotionResponseEntity>> {
        val result = promotionDataSource.getPromotions()
        return when (result) {
            is ServiceResult.Success -> {
                ServiceResult.Success(result.data.toEntityList())
            }
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }
}