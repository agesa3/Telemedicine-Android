package com.agesadev.telmed.presentation.login

import com.agesadev.telmed.domain.model.LoginResponse

sealed class LoginState {
    class Success(val response: LoginResponse) : LoginState()
    class Failure(val error: String) : LoginState()
    object Empty : LoginState()
}