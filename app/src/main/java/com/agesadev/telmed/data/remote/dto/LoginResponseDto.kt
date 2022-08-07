package com.agesadev.telmed.data.remote.dto

import com.agesadev.telmed.domain.model.LoginResponse

data class LoginResponseDto(
    val email: String,
    val token: String,
    val user_id: Int,
    val username: String
) {
    fun toLoginResponse(): LoginResponse {
        return LoginResponse(
            email = email,
            token = token,
            user_id = user_id,
            username = username
        )
    }
}