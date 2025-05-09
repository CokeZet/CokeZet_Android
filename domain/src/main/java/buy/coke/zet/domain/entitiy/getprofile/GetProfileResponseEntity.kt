package buy.coke.zet.domain.entitiy.getprofile

data class GetProfileResponseEntity(
    val id: Long? = null,
    val email: String? = null,
    val nickname: String? = null,
    val profileComplete: Boolean? = null,
    val preferredCommerces: List<CommerceEntity>? = null,
    val preferredCardCompanies: List<CardCompanyEntity>? = null
)

data class CommerceEntity(
    val id: String? = null,
    val name: String? = null
)

data class CardCompanyEntity(
    val id: String? = null,
    val name: String? = null
)