package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.product.GetProductDetailResponseDto
import buy.coke.zet.data.dto.product.GetProductResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {
    @GET("/api/v1/products")
    suspend fun getProducts(
        @Query("brand") brand: String? = null,
        @Query("productSize") productSize: Int? = null,
        @Query("storeName") storeName: String? = null,
        @Query("discountType") discountType: String? = null,
        @Query("cardName") cardName: String? = null,
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null
    ): Response<CommonResponseDto<List<GetProductResponseDto>>>

    @GET("api/v1/products/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Long
    ): Response<CommonResponseDto<GetProductDetailResponseDto>>
}