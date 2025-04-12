package buy.coke.zet.data.dto.updateprofile

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequestDto(
    @SerializedName("nickname") val nickname: String? = null,
    @SerializedName("commerceIds") val commerceIds: List<Long>? = null,
    @SerializedName("cardCompanyIds") val cardCompanyIds: List<Long>? = null
)