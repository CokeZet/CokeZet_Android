package buy.coke.zet.domain.entitiy.product

data class GetProductRequestEntity(
    val brand: String? = null,
    val productSize: Int? = null,
    val storeName: String? = null,
    val discountType: String? = null,
    val cardName: String? = null
)