package buy.coke.zet.data.errorhandle

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.domain.ServiceResult
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

// Response Body가 null이 아닌 API호출을 할 때 사용
suspend fun <T> safeApiCall(apiCall: suspend () -> Response<CommonResponseDto<T>>): ServiceResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()

            if (body != null) {
                return when {
                    body.code?.uppercase() == "SUCCESS" && body.data != null -> {
                        ServiceResult.Success(body.data)
                    }
                    else -> {
                        ServiceResult.Error(body.code ?: "UNKNOWN_ERROR", body.message ?: "알 수 없는 오류 발생")
                    }
                }
            } else {
                ServiceResult.Error("NULL_BODY", "Response Body의 값이 null 입니다.")
            }
        } else {
            val errorBodyString = response.errorBody()?.string()
            val errorResponse = try {
                Gson().fromJson(errorBodyString, CommonResponseDto::class.java)
            } catch (e: Exception) {
                null
            }

            val errorCode = errorResponse?.code ?: response.code().toString()
            val errorMessage = errorResponse?.message ?: response.message()
            ServiceResult.Error(errorCode, errorMessage)
        }

    } catch (e: IOException) {
        ServiceResult.NetworkError
    } catch (e: Exception) {
        ServiceResult.Error("EXCEPTION", e.localizedMessage ?: "네트워크 요청 중 알 수 없는 오류 발생")
    }
}