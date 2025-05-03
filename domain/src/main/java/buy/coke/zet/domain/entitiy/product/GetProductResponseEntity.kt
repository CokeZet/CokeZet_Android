package buy.coke.zet.domain.entitiy.product

data class GetProductResponseEntity(
    val productId: Long,
    val storeProductId: Long,
    val price: Int,
    val pricePerMl: Int,
    val discountRate: Int,
    val size: String,
    val brand: String,
    val count: Int,
    val taste: String,
    val storeName: String,
    val cardNameList: List<String>
)