package buy.coke.zet.domain.entitiy.updateprofile

data class UpdateProfileResponseEntity(
    val email: String? = null,
    val nickname: String? = null,
    val commerceNames: List<String>,
    val notificationEnabled: Boolean,
    val receiveNotificationAfter8PM: Boolean
)