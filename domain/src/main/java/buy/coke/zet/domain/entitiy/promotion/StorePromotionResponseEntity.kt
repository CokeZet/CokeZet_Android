package buy.coke.zet.domain.entitiy.promotion

data class StorePromotionResponseEntity(
    val storeName: String? = null,
    val promotions: List<PromotionItemEntity>? = null
)

data class PromotionItemEntity(
    val productId: Int? = null,
    val productName: String? = null,
    val size: String? = null,
    val promotionTypeLabel: String? = null,
    val price: Int? = null
)