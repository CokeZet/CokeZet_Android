package buy.coke.zet.domain.entitiy.contents

data class GetNoticeResponseEntity(
    val id: Long? = null,
    val title: String? = null,
    val content: String? = null,
    val createdAt: String? = null,
    val important: Boolean? = null
)