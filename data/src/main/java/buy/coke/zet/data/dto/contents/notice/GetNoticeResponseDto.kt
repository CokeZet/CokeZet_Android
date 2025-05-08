package buy.coke.zet.data.dto.contents.notice

import com.google.gson.annotations.SerializedName

data class GetNoticeResponseDto(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("important") val important: Boolean
)