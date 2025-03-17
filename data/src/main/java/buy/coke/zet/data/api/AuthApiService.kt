package buy.coke.zet.data.api

import buy.coke.zet.data.dto.request.LoginRequestDto
import buy.coke.zet.data.dto.request.RefreshRequestDto
import buy.coke.zet.data.dto.response.CommonResponseDto
import buy.coke.zet.data.dto.response.LoginResponseDto
import buy.coke.zet.data.dto.response.RefreshResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequestDto): Response<CommonResponseDto<LoginResponseDto>>

    @POST("/api/auth/refresh")
    suspend fun refresh(@Body request: RefreshRequestDto): Response<CommonResponseDto<RefreshResponseDto>>
}