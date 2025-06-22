package buy.coke.zet.domain.entitiy.getprofile

data class GetProfileResponseEntity(
    val email: String? = null,
    val nickname: String? = null,
    val commerceNames: List<String>,
    val notificationEnabled: Boolean,
    val receiveNotificationAfter8PM: Boolean
)