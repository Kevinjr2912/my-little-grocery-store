package com.softgenix.miabarrotito.features.auth.data.repositories

import android.util.Log
import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.mapper.toDomain
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.domain.entities.UserEntity
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository
import kotlin.toString

class AuthRepositoryImplementation(
    private val api: MiAbarrotitoApi
) : AuthRepository {

    override suspend fun registerUser(user: RegisterRequest): Result<UserEntity> {

        return try {
            val response = api.createUser(user)
            Log.d("RegistroExitoso", response.toString())
            Result.success(response.toDomain())
        } catch (e: Exception) {
            Log.e("RegistroError", e.message.toString())
            Result.failure(e)
        }
    }
}