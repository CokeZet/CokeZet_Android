package buy.coke.zet.data.mapper

import buy.coke.zet.domain.ServiceResult

fun <T> ServiceResult<T?>.mapToUnit(): ServiceResult<Unit> {
    return when (this) {
        is ServiceResult.Success -> ServiceResult.Success(Unit)
        is ServiceResult.Error -> this
        ServiceResult.NetworkError -> ServiceResult.NetworkError
    }
}