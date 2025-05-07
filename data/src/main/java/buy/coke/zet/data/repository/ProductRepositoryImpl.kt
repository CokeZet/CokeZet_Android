package buy.coke.zet.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import buy.coke.zet.data.datasource.ProductDataSource
import buy.coke.zet.data.datasource.ProductPagingSource
import buy.coke.zet.data.mapper.toDto
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
}