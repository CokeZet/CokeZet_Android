package buy.coke.zet.domain.entitiy.getprofile

data class GetProfileResponseEntity(
    val id: Long,
    val email: String,
    val nickname: String,
    val profileComplete: Boolean,
    val preferredCommerces: List<CommerceEntity>,
    val preferredCardCompanies: List<CardCompanyEntity>
)

data class CommerceEntity(
    val id: String,
    val name: String
)

data class CardCompanyEntity(
    val id: String,
    val name: String
)