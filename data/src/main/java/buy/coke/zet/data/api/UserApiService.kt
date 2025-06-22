package buy.coke.zet.data.api

import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.getprofile.GetProfileResponseDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileRequestDto
import buy.coke.zet.data.dto.updateprofile.UpdateProfileResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserApiService {
    @DELETE("/api/users/profile")
    suspend fun delete(): Response<CommonResponseDto<Unit>>

    @PATCH("/api/users/profile")
    suspend fun updateProfile(@Body request: UpdateProfileRequestDto): Response<CommonResponseDto<UpdateProfileResponseDto>>

    @GET("/api/users/profile")
    suspend fun getProfile(): Response<CommonResponseDto<GetProfileResponseDto>>
}