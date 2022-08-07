package com.agesadev.telmed.data.remote.dto

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RemoteApi {

    @Headers("Content-Type:application/json")
    @POST("signin")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): LoginResponseDto
}