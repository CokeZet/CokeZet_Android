package buy.coke.zet.domain.entitiy.updateprofile

data class UpdateProfileRequestEntity(
    val nickname: String? = null,
    val commerceIds: String? = null,
    val notificationEnabled: Boolean? = null,
    val receiveNotificationAfter8PM: Boolean? = null,
    val fcmToken: String? = null
)