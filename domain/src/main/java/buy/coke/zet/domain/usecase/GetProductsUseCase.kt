package buy.coke.zet.domain.usecase

import androidx.paging.PagingData
import buy.coke.zet.domain.entitiy.product.GetProductRequestEntity
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity
import buy.coke.zet.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** 상품 조회 유스케이스
 *  상품을 조회할 수 있습니다. Paging 처리 했습니다.
 *  과도한 쿼리호출을 방지하기위해 초기에 20개 데이터를 미리불러오고 그 이후 5개씩 쿼리 호출 합니다.
 * 매개변수에 예시로
 * brand = "코카콜라"
 * productSize = "190"
 * storeName = "11번가"
 * discountType = "제트픽"
 * cardName = "신한"
 * 같은 형식 으로 요청하시면 됩니다.
 *
 * Response는
 *     {
 *       "productId": 1,
 *       "storeProductId": 1,
 *       "price": 1000,
 *       "pricePerMl": 154,
 *       "discountRate": 10,
 *       "size": "500ml",
 *       "brand": "코카콜라",
 *       "count": 24,
 *       "taste": "라임",
 *       "storeName": "11번가",
 *       "cardNameList": "신한카드, 삼성카드"
 *     }
 *     위와 같은 형식 으로 내려옵니다.
 */

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(products: GetProductRequestEntity): Flow<PagingData<GetProductResponseEntity>> {
        return productRepository.getProducts(products)
    }
}