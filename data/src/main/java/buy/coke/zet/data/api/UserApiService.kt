package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface UserApiService {
    @DELETE("/api/users/profile")
    suspend fun delete(): Response<CommonResponseDto<Unit>>

    @POST("/api/users/profile")
    suspend fun updateProfile(@Body request: UpdateProfileRequestDto): Response<CommonResponseDto<Unit>>
}