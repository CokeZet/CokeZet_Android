package buy.coke.zet.data.dto.getprofile

import com.google.gson.annotations.SerializedName

data class GetProfileResponseDto(
    @SerializedName("email") val email: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("commerceNames") val commerceNames: List<String>,
    @SerializedName("notificationEnabled") val notificationEnabled: Boolean,
    @SerializedName("receiveNotificationAfter8PM") val receiveNotificationAfter8PM: Boolean
)