package com.softgenix.miabarrotito.features.auth.domain.repositories

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.domain.entities.UserEntity

interface AuthRepository {
    suspend fun registerUser(user: RegisterRequest): Result<UserEntity>

}