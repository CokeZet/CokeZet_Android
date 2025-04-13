package buy.coke.zet.data.mapper

import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
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