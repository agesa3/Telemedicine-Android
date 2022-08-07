package com.agesadev.telmed.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agesadev.telmed.core.Resource
import com.agesadev.telmed.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Empty)
    val loginState = _loginState.asStateFlow()


    fun login(email: String, password: String) {
        viewModelScope.launch {
            when (val response = loginRepository.loginUser(email, password)) {
                is Resource.Success -> _loginState.value = LoginState.Success(response.data!!)
                is Resource.Error -> _loginState.value =
                    LoginState.Failure(response.error ?: "Login Error")
                else -> Unit
            }
        }
    }
}