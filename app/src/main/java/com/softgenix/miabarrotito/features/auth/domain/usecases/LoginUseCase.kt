package com.softgenix.miabarrotito.features.auth.domain.usecases

import com.softgenix.miabarrotito.features.auth.domain.entities.AuthToken
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository

class LoginUseCase ( private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<AuthToken> {
        return if (email.isBlank() || password.isBlank()) {
            Result.failure(Exception("Correo y contraseña son obligatorios"))
        } else {
            repository.login(email, password)
        }
    }
}