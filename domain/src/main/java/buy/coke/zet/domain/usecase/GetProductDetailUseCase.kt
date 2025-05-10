package buy.coke.zet.domain.usecase

import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.product.GetProductDetailResponseEntity
import buy.coke.zet.domain.repository.ProductRepository
import javax.inject.Inject

/** 상품 상세 조회 유스케이스
 *  상품의 상세 내용을 조회 합니다.
 *  productId를 요청하면
 *  GetProductDetailResponseEntity 응답값 예시로
 *     "id": 1,
 *     "storeProductId": 6360152106,
 *     "price": 1000,
 *     "pricePerMl": 154,
 *     "discountRate": 10,
 *     "size": "500",
 *     "brand": "코카콜라",
 *     "count": 24,
 *     "taste": "라임",
 *     "storeName": "11번가",
 *     "cardNameList": "신한, 삼성", ( List 입니다. )
 *     "productUrl": "https://www.11st.co.kr/products/6360152106"
 *     형태로 값이 내려옵니다.
 */

class GetProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(productId: Long): ServiceResult<GetProductDetailResponseEntity> {
        return productRepository.getProductDetail(productId)
    }
}