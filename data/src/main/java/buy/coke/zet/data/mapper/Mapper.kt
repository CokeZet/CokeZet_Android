package buy.coke.zet.data.mapper

import buy.coke.zet.data.dto.getprofile.GetProfileResponseDto
import buy.coke.zet.data.dto.getprofile.PreferredCardCompany
import buy.coke.zet.data.dto.getprofile.PreferredCommerce
import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.data.dto.product.GetProductRequestDto
import buy.coke.zet.data.dto.product.GetProductResponseDto
import buy.coke.zet.data.dto.promotions.PromotionItem
import buy.coke.zet.data.dto.promotions.PromotionResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import buy.coke.zet.domain.entitiy.getprofile.CardCompanyEntity
import buy.coke.zet.domain.entitiy.getprofile.CommerceEntity
import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.entitiy.promotion.PromotionItemEntity
import buy.coke.zet.domain.entitiy.promotion.StorePromotionResponseEntity
import buy.coke.zet.domain.entitiy.login.LoginResponseEntity
import buy.coke.zet.domain.entitiy.product.GetProductRequestEntity
import buy.coke.zet.domain.entitiy.product.GetProductResponseEntity
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

fun GetProductRequestEntity.toDto(
    page: Int? = null,
    size: Int? = null
): GetProductRequestDto {
    return GetProductRequestDto(
        brand = this.brand,
        productSize = this.productSize,
        storeName = this.storeName,
        discountType = this.discountType,
        cardName = this.cardName,
        page = page,
        size = size
    )
}


fun GetProductResponseDto.toEntity(): GetProductResponseEntity {
    return GetProductResponseEntity(
        productId = this.productId ?: 0,
        storeProductId = this.storeProductId ?: 0,
        price = this.price ?: 0,
        pricePerMl = this.pricePerMl ?: 0,
        discountRate = this.discountRate ?: 0,
        size = this.size.orEmpty(),
        brand = this.brand.orEmpty(),
        count = this.count ?: 0,
        taste = this.taste.orEmpty(),
        storeName = this.storeName.orEmpty(),
        cardNameList = this.cardNameList.orEmpty()
    )
}

fun GetProfileResponseDto.toEntity(): GetProfileResponseEntity {
    return GetProfileResponseEntity(
        id = id,
        email = email,
        nickname = nickname,
        profileComplete = profileComplete,
        preferredCommerces = preferredCommerces.map { it.toEntity() },
        preferredCardCompanies = preferredCardCompanies.map { it.toEntity() }
    )
}

fun PreferredCommerce.toEntity(): CommerceEntity {
    return CommerceEntity(
        id = id,
        name = name
    )
}

fun PreferredCardCompany.toEntity(): CardCompanyEntity {
    return CardCompanyEntity(
        id = id,
        name = name
    )
}