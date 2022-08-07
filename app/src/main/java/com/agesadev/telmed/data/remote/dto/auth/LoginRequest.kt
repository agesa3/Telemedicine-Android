package com.agesadev.telmed.data.remote.dto.auth

data class LoginRequest(
    val email: String,
    val password: String
)