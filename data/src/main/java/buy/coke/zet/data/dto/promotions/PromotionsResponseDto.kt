package buy.coke.zet.data.dto.promotions

data class PromotionResponseDto(
    val year: Int,
    val month: Int,
    val storePromotions: Map<String, List<PromotionItem>>
)

data class PromotionItem(
    val productId: Int,
    val productName: String,
    val size: String,
    val brand: String,
    val promotionType: String,
    val price: Int
)