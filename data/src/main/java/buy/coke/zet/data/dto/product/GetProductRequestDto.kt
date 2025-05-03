package buy.coke.zet.data.dto.product

data class GetProductRequestDto(
    val brand: String? = null,
    val productSize: Int? = null,
    val storeName: String? = null,
    val discountType: String? = null,
    val cardName: String? = null,
    val page: Int? = null,
    val size: Int? = null
)
