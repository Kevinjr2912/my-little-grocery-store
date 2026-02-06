package com.softgenix.miabarrotito.core.network

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterResponse
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.CreateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.CreateProductResponseDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.ProductResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MiAbarrotitoApi {

    @POST("auth/sign-up")
    suspend fun createUser(@Body user: RegisterRequest): RegisterResponse

    @POST("products")
    suspend fun createProduct(
        @Body body: CreateProductRequestDto
    ): CreateProductResponseDto
    @GET("products/business/{businessId}")
    suspend fun getProductsByBusiness(
        @Path("businessId") businessId: String
    ): ProductResponseDto

    @DELETE("products/{productId}")
    suspend fun deleteProduct(
        @Path("productId") productId: String
    ): Response<Unit>


}









