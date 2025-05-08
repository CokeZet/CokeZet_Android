package buy.coke.zet.domain.entitiy.contents

data class GetNoticeResponseEntity(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
    val important: Boolean
)