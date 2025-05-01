package buy.coke.zet.domain.usecase

import androidx.paging.PagingData
import buy.coke.zet.domain.entitiy.product.GetProductRequestEntity
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity
import buy.coke.zet.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** 상품 조회 유스케이스
 *  상품을 조회할 수 있습니다. Paging 처리 했습니다.
 *
 */
class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(products: GetProductRequestEntity): Flow<PagingData<GetProductResponseEntity>> {
        return productRepository.getProducts(products)
    }
}