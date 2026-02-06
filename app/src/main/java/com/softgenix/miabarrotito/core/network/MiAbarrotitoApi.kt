package com.softgenix.miabarrotito.core.network

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterResponse
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.ProductResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MiAbarrotitoApi {

    @POST("auth/sign-up")
    suspend fun createUser(@Body user: RegisterRequest): RegisterResponse

    @GET("products/business/{businessId}")
    suspend fun getProductsByBusiness(
        @Path("businessId") businessId: String
    ): ProductResponseDto


}









