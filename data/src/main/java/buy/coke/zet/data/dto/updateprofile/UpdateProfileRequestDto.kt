package buy.coke.zet.data.dto.updateprofile

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequestDto(
    @SerializedName("nickname") val nickname: String? = null,
    @SerializedName("commerceIds") val commerceIds: String? = null,
    @SerializedName("notificationEnabled") val notificationEnabled: Boolean? = null,
    @SerializedName("receiveNotificationAfter8PM") val receiveNotificationAfter8PM: Boolean? = null,
    @SerializedName("fcmToken") val fcmToken: String? = null
)