package com.agesadev.telmed.domain.model

data class LoginResponse(
    val email: String,
    val token: String,
    val user_id: Int,
    val username: String
)