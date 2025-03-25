package buy.coke.zet.data.dto.login

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    @SerializedName("idToken") val idToken: String? = null,
    @SerializedName("provider") val provider: String? = null
)