package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import retrofit2.Response
import retrofit2.http.DELETE

interface UserApiService {
    @DELETE("/api/users/profile")
    suspend fun delete(): Response<CommonResponseDto<Unit>>
}