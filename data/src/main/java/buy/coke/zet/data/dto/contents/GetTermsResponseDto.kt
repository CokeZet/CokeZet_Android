package buy.coke.zet.data.dto.contents

import com.google.gson.annotations.SerializedName

data class GetTermsResponseDto(
    @SerializedName("id") val id: Long,
    @SerializedName("type") val type: String,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("updatedAt") val updatedAt: String
)