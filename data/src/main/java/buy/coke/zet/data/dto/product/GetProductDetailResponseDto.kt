package buy.coke.zet.data.dto.product

import com.google.gson.annotations.SerializedName

data class GetProductDetailResponseDto(
    @SerializedName("id") val id: Long,
    @SerializedName("storeProductId") val storeProductId: Long,
    @SerializedName("price") val price: Int,
    @SerializedName("pricePerMl") val pricePerMl: Int,
    @SerializedName("discountRate") val discountRate: Int,
    @SerializedName("size") val size: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("count") val count: Int,
    @SerializedName("taste") val taste: String,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("cardNameList") val cardNameList: String,
    @SerializedName("productUrl") val productUrl: String
)
