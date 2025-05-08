package buy.coke.zet.domain.entitiy.product

data class GetProductResponseEntity(
    val productId: Long? = null,
    val storeProductId: Long? = null,
    val price: Int? = null,
    val pricePerMl: Int? = null,
    val discountRate: Int? = null,
    val size: String? = null,
    val brand: String? = null,
    val count: Int? = null,
    val taste: String? = null,
    val storeName: String? = null,
    val cardNameList: List<String>? = null
)