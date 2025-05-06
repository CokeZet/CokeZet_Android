package buy.coke.zet.data.dto.getprofile

import com.google.gson.annotations.SerializedName

data class GetProfileResponseDto(
    @SerializedName("id") val id: Long,
    @SerializedName("email") val email: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profileComplete") val profileComplete: Boolean,
    @SerializedName("preferredCommerces") val preferredCommerces: List<PreferredCommerce>,
    @SerializedName("preferredCardCompanies") val preferredCardCompanies: List<PreferredCardCompany>
)

data class PreferredCommerce(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)

data class PreferredCardCompany(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)