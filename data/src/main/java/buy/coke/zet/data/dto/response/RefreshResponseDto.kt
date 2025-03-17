package buy.coke.zet.data.dto.response

import com.google.gson.annotations.SerializedName

data class RefreshResponseDto(
    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("refreshToken") val refreshToken: String? = null
)