package com.agesadev.telmed.domain.repository

import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.domain.model.LoginResponse

interface LoginRepository {
    suspend fun loginUser(
        email: String,
        password: String
    ): Resource<LoginResponse>
}