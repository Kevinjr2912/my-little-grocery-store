package com.softgenix.miabarrotito.features.auth.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.domain.usecases.RegisterUseCase
import com.softgenix.miabarrotito.features.auth.presentation.screens.RegisterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {



    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _secondSurname = MutableStateFlow("")
    val secondSurname = _secondSurname.asStateFlow()

    private val _phone = MutableStateFlow("")
    val phone = _phone.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _error.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    fun onChangename( it : String) {
        _name.value = it
    }

    fun onChangeSecondSurname(it : String) {
        _secondSurname.value = it
    }

    fun onChangePhone(it : String) {
        _phone.value = it
    }

    fun onChangeEmail(it : String) {
        _email.value = it
    }


    fun onChangePassword(it : String) {
        _password.value = it
    }

    fun onChangeConfirmPassword(it : String) {
        _confirmPassword.value = it
    }



    // con est funcion dispararemos el proceso, so de que primero evaluamos,
    //luego encndemos el cargador y limpiamos errores
    //contiamente preparamos al request
    //luego llamamos al useacse
    //y final recibimos el resutl
    fun onRegister() {

        if (_password.value != _confirmPassword.value) {
            _error.value = "Las contraseñas no coinciden"
            return
        }

        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            try {
                val request = RegisterRequest(
                    userUUID = java.util.UUID.randomUUID().toString(),
                    name = _name.value,
                    secondSurname = _secondSurname.value,
                    phoneNumber = _phone.value,
                    email = _email.value,
                    password = _password.value
                )


                val result = registerUseCase(request)

                result.fold(
                    onSuccess = { user ->
                        _isLoading.value = false
                        _uiState.value.isSuccess = true
                        Log.d("Registro", "Usuario creado: ${user.fullName}")
                    },
                    onFailure = { e ->
                        _isLoading.value = false
                        _error.value = e.message ?: "Error al registrar"
                    }
                )
            } catch (e: Exception) {
                _isLoading.value = false
                _error.value = "Falla de red: ${e.message}"
            }
        }
    }
}