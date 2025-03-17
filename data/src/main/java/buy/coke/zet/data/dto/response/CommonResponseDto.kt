package buy.coke.zet.data.dto.response

import com.google.gson.annotations.SerializedName

data class CommonResponseDto<T>(
    @SerializedName("code") val code: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("data") val data: T? = null
)