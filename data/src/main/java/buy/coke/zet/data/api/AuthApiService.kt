package buy.coke.zet.data.api

import buy.coke.zet.data.dto.login.LoginRequestDto
import buy.coke.zet.data.dto.refresh.RefreshRequestDto
import buy.coke.zet.data.dto.CommonResponseDto
import buy.coke.zet.data.dto.login.LoginResponseDto
import buy.coke.zet.data.dto.refresh.RefreshResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequestDto): Response<CommonResponseDto<LoginResponseDto>>

    @GET("api/auth/login")
    suspend fun getLogin(): Response<CommonResponseDto<LoginResponseDto>>

    @POST("/api/auth/refresh")
    suspend fun refresh(@Body request: RefreshRequestDto): Response<CommonResponseDto<RefreshResponseDto>>

    @POST("/api/auth/logout")
    suspend fun logout(): Response<CommonResponseDto<Unit>>
}