package buy.coke.zet.data.dto.delete

import com.google.gson.annotations.SerializedName

data class DeleteRequestDto(
    @SerializedName("socialProvider") val socialProvider: String? = "GOOGLE",
    @SerializedName("revokeToken") val revokeToken: String?= null
)