package buy.coke.zet.data.dto.login

import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("refreshToken") val refreshToken: String? = null,
    @SerializedName("user") val user: UserInfo? = null,
    @SerializedName("newUser") val newUser: Boolean? = null
)

data class UserInfo(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("nickname") val nickname: String? = null
)