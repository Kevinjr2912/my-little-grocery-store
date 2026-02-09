package com.softgenix.miabarrotito.core.network

import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.LoginRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.LoginResponse
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterRequest
import com.softgenix.miabarrotito.features.auth.data.datasoruces.remote.models.RegisterResponse
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.request.CreateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.request.UpdateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.CreateProductResponseDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.ProductResponseDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.UpdateProductResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
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

    @PUT("products/{productId}")
    suspend fun updateProduct(
        @Path("productId") productId: String,
        @Body body: UpdateProductRequestDto
    ): UpdateProductResponseDto

    @DELETE("products/{productId}")
    suspend fun deleteProduct(
        @Path("productId") productId: String
    ): Response<Unit>


    @POST("auth/sign-in")
    suspend fun login(@Body request: LoginRequest): LoginResponse

}









