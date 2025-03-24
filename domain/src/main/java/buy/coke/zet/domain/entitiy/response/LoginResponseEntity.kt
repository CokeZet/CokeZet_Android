package buy.coke.zet.domain.entitiy.response

data class LoginResponseEntity(
    val id: Long? = null,
    val email: String? = null,
    val nickname: String? = null,
    val newUser: Boolean? = null
)
