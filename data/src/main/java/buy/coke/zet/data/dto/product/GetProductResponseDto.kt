package buy.coke.zet.data.dto.product

import com.google.gson.annotations.SerializedName

data class GetProductResponseDto(
    @SerializedName("productId") val productId: Int? = null,
    @SerializedName("storeProductId") val storeProductId: Int? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("pricePerMl") val pricePerMl: Int? = null,
    @SerializedName("discountRate") val discountRate: Int? = null,
    @SerializedName("size") val size: String? = null,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("count") val count: Int? = null,
    @SerializedName("taste") val taste: String? = null,
    @SerializedName("storeName") val storeName: String? = null,
    @SerializedName("cardNameList") val cardNameList: String? = null
)