package buy.coke.zet.data.mapper

import buy.coke.zet.data.dto.request.LoginRequestDto
import buy.coke.zet.data.dto.response.LoginResponseDto
import buy.coke.zet.data.model.GoogleAuthModel
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity

fun LoginResponseDto.toEntity(): LoginResponseEntity {
    return LoginResponseEntity(
        id = this.user?.id,
        email = this.user?.email,
        nickname = this.user?.nickname,
        newUser = newUser
    )
}

fun GoogleAuthModel.toDto(): LoginRequestDto {
    return LoginRequestDto(
        idToken = this.idToken,
        provider = this.provider
    )
}