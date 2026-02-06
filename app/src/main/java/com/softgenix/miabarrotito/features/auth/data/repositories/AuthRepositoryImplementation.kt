package com.softgenix.miabarrotito.features.auth.data.repositories

import android.util.Log
import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.auth.data.datasoruces.local.AuthLocalDataSource
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.mapper.toDomain
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.LoginRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.domain.entities.AuthToken
import com.softgenix.miabarrotito.features.auth.domain.entities.UserEntity
import com.softgenix.miabarrotito.features.auth.domain.repositories.AuthRepository
import kotlin.toString

class AuthRepositoryImplementation(
    private val api: MiAbarrotitoApi,
    private val localDataSource: AuthLocalDataSource
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

    override suspend fun login(email: String, password: String): Result<AuthToken> {
        return try {
            val response = api.login(LoginRequest(email, password))
            val token = response.toDomain()

            localDataSource.saveToken(token.value)
            Log.d("LOGIN_OK", "Token guardado correctamente")

            Result.success(token)
        } catch (e: retrofit2.HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("LOGIN_API_ERROR", "Código: ${e.code()} - Body: $errorBody")
            Result.failure(Exception("Credenciales incorrectas (401)"))
        } catch (e: Exception) {
            Log.e("LOGIN_FATAL", "Error de red o mapeo: ${e.message}")
            Result.failure(e)
        }
    }
}