package buy.coke.zet.domain.repository

import androidx.paging.PagingData
import buy.coke.zet.domain.entitiy.product.GetProductRequestEntity
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(request: GetProductRequestEntity): Flow<PagingData<GetProductResponseEntity>>
}