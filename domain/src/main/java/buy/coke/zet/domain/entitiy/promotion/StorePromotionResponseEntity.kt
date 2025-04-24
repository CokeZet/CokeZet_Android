package buy.coke.zet.domain.entitiy.promotion

data class StorePromotionResponseEntity(
    val storeName: String,
    val promotions: List<PromotionItemEntity>
)

data class PromotionItemEntity(
    val productId: Long,
    val productName: String,
    val size: String,
    val brand: String,
    val promotionTypeLabel: String,
    val price: Int
)