package com.softgenix.miabarrotito.features.auth.presentation.screens

data class RegisterUiState(
 //para el form aun no lo usare en esta feature
    val name: String = "",
    val secondSurname: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = "",

// para la api
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false

)