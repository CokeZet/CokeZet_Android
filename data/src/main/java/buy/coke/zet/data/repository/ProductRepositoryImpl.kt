package buy.coke.zet.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import buy.coke.zet.data.datasource.ProductDataSource
import buy.coke.zet.data.datasource.ProductPagingSource
import buy.coke.zet.data.mapper.toDto
import buy.coke.zet.data.mapper.toEntity
import buy.coke.zet.domain.ServiceResult
import buy.coke.zet.domain.entitiy.product.GetProductDetailResponseEntity
import buy.coke.zet.domain.entitiy.product.GetProductRequestEntity
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity
import buy.coke.zet.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
) : ProductRepository {

    override fun getProducts(request: GetProductRequestEntity): Flow<PagingData<GetProductResponseEntity>> {
        val requestDto = request.toDto()

        return Pager(
            config = PagingConfig(
                pageSize = 5,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ProductPagingSource(
                    productDataSource = productDataSource,
                    requestDto = requestDto
                )
            }
        ).flow
    }

    override suspend fun getProductDetail(productId: Long): ServiceResult<GetProductDetailResponseEntity> {
        val result = productDataSource.getProductDetail(productId)
        return when (result) {
            is ServiceResult.Success -> ServiceResult.Success(result.data.toEntity())
            is ServiceResult.Error -> ServiceResult.Error(result.code, result.message)
            is ServiceResult.NetworkError -> ServiceResult.NetworkError
        }
    }
}