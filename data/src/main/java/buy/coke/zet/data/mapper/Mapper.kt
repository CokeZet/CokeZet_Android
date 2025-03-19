package buy.coke.zet.data.mapper

import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.domain.entitiy.response.LoginResponseEntity

fun LoginResponseDto.toEntity(): LoginResponseEntity {
    return LoginResponseEntity(
        id = this.user?.id,
        email = this.user?.email,
        nickname = this.user?.nickname,
        newUser = newUser
    )
}