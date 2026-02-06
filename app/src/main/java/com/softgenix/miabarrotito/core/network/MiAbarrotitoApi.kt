package com.softgenix.miabarrotito.core.network

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MiAbarrotitoApi {

    @POST("auth/sign-up")
    suspend fun createUser(@Body user: RegisterRequest): RegisterResponse




}









