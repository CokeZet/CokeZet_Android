package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity
import buy.coke.zet.domain.repository.PromotionRepository
import javax.inject.Inject

/** 편의점 프로모션 유스케이스
 * 편의점 스티키 (배너) 를 설정할 수 있는 유스케이스 입니다.
 * StorePromotionResponseEntity의
 * storeName = GS25
 * productName = 펩시제로라임
 * size = 500ml
 * promotionType = 1+1
 * price = 2000
 * 형식 으로 데이터를 내려주고 있습니다.
 */

class GetPromotionUseCase @Inject constructor(
    private val repository: PromotionRepository
) {
    suspend operator fun invoke(): ServiceResult<List<StorePromotionResponseEntity>> {
        return repository.getStorePromotions()
    }
}