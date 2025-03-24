package buy.coke.zet.data.dto.refresh

import com.google.gson.annotations.SerializedName

data class RefreshRequestDto(
    @SerializedName("refreshToken") val refreshToken: String? = null,
)