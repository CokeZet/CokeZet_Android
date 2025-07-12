package buy.coke.zet.presentation.model

import buy.coke.zet.domain.entitiy.getprofile.GetProfileResponseEntity
import buy.coke.zet.domain.entitiy.login.LoginResponseEntity

data class UserInfo(
    val email: String,
    val nickname: String,
    val commerceNames: List<String> = emptyList(),
    val notificationEnabled: Boolean = false,
    val receiveNotificationAfter8PM: Boolean = false,
    val id: Long? = null,
    val newUser: Boolean? = null
)

fun LoginResponseEntity.toUserInfo(): UserInfo {
    return UserInfo(
        email = this.email.orEmpty(),
        nickname = this.nickname.orEmpty(),
        id = this.id,
        newUser = this.newUser
    )
}

fun GetProfileResponseEntity.toUserInfo(): UserInfo {
    return UserInfo(
        email = this.email.orEmpty(),
        nickname = this.nickname.orEmpty(),
        commerceNames = this.commerceNames,
        notificationEnabled = this.notificationEnabled,
        receiveNotificationAfter8PM = this.receiveNotificationAfter8PM
    )
}
