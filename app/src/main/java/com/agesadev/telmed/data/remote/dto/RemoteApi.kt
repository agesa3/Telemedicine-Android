package com.agesadev.telmed.data.remote.dto

import com.agesadev.telmed.data.remote.dto.auth.LoginRequest
import com.agesadev.telmed.data.remote.dto.auth.LoginResponseDto
import com.agesadev.telmed.data.remote.dto.patient.PatientResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RemoteApi {

    @Headers("Content-Type:application/json")
    @POST("doctors/signin")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): LoginResponseDto

    //    @Headers("Content-Type:application/json")
    @GET("patients")
    suspend fun getPatients(): PatientResponseDto
}