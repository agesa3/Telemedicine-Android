package com.agesadev.telmed.data.repository

import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.data.remote.dto.auth.LoginRequest
import com.agesadev.telmed.data.remote.dto.RemoteApi
import com.agesadev.telmed.domain.model.LoginResponse
import com.agesadev.telmed.domain.repository.LoginRepository
import retrofit2.HttpException
import java.io.IOException

class LoginRepositoryImpl(
    private val remoteApi: RemoteApi
) : LoginRepository {
    override suspend fun loginUser(email: String, password: String): Resource<LoginResponse> {
        val loginRequestModel = LoginRequest(email, password)
        return try {
            val response = remoteApi.loginUser(loginRequestModel).toLoginResponse()
            Resource.Success(response)
        } catch (e: HttpException) {
            Resource.Error(error = e.message ?: "Unknown Error")
        } catch (e: IOException) {
            Resource.Error(error = e.message ?: "Unknown Error")
        }
    }


}
