package buy.coke.zet.domain

sealed class ServiceResult<out T> {
    data class Success<out T>(val data: T) : ServiceResult<T>()
    data class Error(val code: String, val message: String?) : ServiceResult<Nothing>()
    data object NetworkError : ServiceResult<Nothing>()
}