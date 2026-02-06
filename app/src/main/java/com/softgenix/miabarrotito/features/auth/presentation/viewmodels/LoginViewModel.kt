package com.softgenix.miabarrotito.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.miabarrotito.features.auth.domain.usecases.LoginUseCase
import com.softgenix.miabarrotito.features.auth.presentation.screens.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {


    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isState = MutableStateFlow(LoginUiState())
    val uiState = _isState.asStateFlow()

    fun onEmailChange(it: String) {
        _email.value = it
    }

    fun onPasswordChange(it: String) {
        _password.value = it
    }

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _error.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess = _isSuccess.asStateFlow()


    fun onLogin() {
        if (_email.value.isBlank() || _password.value.isBlank()) {
            _error.value = "Por favor, llena todos los campos"
            return
        }

        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            try {
                val result = loginUseCase(_email.value, _password.value)

                result.fold(
                    onSuccess = {
                        _isLoading.value = false
                        _isSuccess.value = true
                    },
                    onFailure = { e ->
                        _isLoading.value = false
                        _error.value = e.message ?: "Credenciales incorrectas"
                    }
                )
            } catch (e: Exception) {
                _isLoading.value = false
                _error.value = "Error de conexión: ${e.message}"
            }
        }
    }
}