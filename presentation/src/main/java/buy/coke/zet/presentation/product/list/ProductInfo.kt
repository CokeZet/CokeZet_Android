package buy.coke.zet.presentation.product.list

data class ProductInfo(
    val id: Int,
    val title: String,
    val discountRate: Int,
    val price: Int,
    val isDeliveryFeeContains: Boolean
)
