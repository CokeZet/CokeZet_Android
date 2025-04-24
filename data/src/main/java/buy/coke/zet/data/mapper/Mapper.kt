package buy.coke.zet.data.mapper

import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.data.dto.promotions.PromotionItem
import buy.coke.zet.data.dto.promotions.PromotionResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import buy.coke.zet.domain.entitiy.promotion.PromotionItemEntity
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity
import buy.coke.zet.domain.entitiy.updateprofile.UpdateProfileRequestEntity

fun LoginResponseDto.toEntity(): LoginResponseEntity {
    return LoginResponseEntity(
        id = this.user?.id,
        email = this.user?.email,
        nickname = this.user?.nickname,
        newUser = newUser
    )
}

fun UpdateProfileRequestEntity.toDto(): UpdateProfileRequestDto {
    return UpdateProfileRequestDto(
        nickname = this.nickname,
        commerceIds = this.commerceIds,
        cardCompanyIds = this.cardCompanyIds
    )
}

fun PromotionItem.toEntity(): PromotionItemEntity {
    return PromotionItemEntity(
        productId = productId,
        productName = productName,
        size = size,
        brand = brand,
        promotionTypeLabel = when (promotionType) {
            "ONE_PLUS_ONE" -> "1+1"
            "TWO_PLUS_ONE" -> "2+1"
            else -> "NONE"
        },
        price = price
    )
}

fun PromotionResponseDto.toEntityList(): List<StorePromotionResponseEntity> {
    return storePromotions.map { (storeName, items) ->
        StorePromotionResponseEntity(
            storeName = storeName,
            promotions = items.map { it.toEntity() }
        )
    }
}