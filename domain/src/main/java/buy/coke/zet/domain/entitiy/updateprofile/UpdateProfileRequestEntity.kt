package buy.coke.zet.domain.entitiy.updateprofile

data class UpdateProfileRequestEntity(
    val nickname: String? = null,
    val commerceIds: List<Long>? = null,
    val cardCompanyIds: List<Long>? = null
)