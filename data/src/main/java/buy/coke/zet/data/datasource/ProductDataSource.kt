package buy.coke.zet.data.datasource

import buy.coke.zet.data.api.ProductApiService
import buy.coke.zet.data.dto.product.GetProductRequestDto
import buy.coke.zet.data.dto.product.GetProductResponseDto
import buy.coke.zet.data.errorhandle.safeApiCall
import buy.coke.zet.domain.ServiceResult
import javax.inject.Inject

interface ProductDataSource {
    suspend fun getProducts(request: GetProductRequestDto): ServiceResult<List<GetProductResponseDto>>
}

class ProductDataSourceImpl @Inject constructor(
    private val apiService: ProductApiService
) : ProductDataSource {
    override suspend fun getProducts(request: GetProductRequestDto): ServiceResult<List<GetProductResponseDto>> {
        return safeApiCall {
            apiService.getProducts(
                brand = request.brand,
                productSize = request.productSize,
                storeName = request.storeName,
                discountType = request.discountType,
                cardName = request.cardName,
                page = request.page,
                size = request.size
            )
        }
    }
}