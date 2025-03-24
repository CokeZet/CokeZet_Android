package buy.coke.zet.data.errorhandle

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.domain.ServiceResult
import retrofit2.Response
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<CommonResponseDto<T>>): ServiceResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                return if (body.code == "SUCCESS" && body.data != null) {
                    ServiceResult.Success(body.data)
                } else {
                    ServiceResult.Error(body.code ?: "UNKNOWN_ERROR", body.message)
                }
            } ?: ServiceResult.Error("NULL_BODY", "Response Body의 값이 null 입니다")
        } else {
            ServiceResult.Error(response.code().toString(), response.message())
        }
    } catch (e: IOException) {
        ServiceResult.NetworkError
    } catch (e: Exception) {
        ServiceResult.Error("EXCEPTION", e.localizedMessage)
    }
}