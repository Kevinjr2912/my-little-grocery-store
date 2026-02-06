package com.softgenix.miabarrotito.features.auth.domain.usecases

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.domain.entities.UserEntity
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: RegisterRequest): Result<UserEntity> {
        return if (user.email.isBlank()) {
            Result.failure(Exception("El correo no puede estar vacío"))
        } else {
            repository.registerUser(user)
        }
    }
}