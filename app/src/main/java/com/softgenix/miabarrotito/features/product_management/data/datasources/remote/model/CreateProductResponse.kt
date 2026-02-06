package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model

data class CreateProductResponseDto(
    val data: CreatedProductDto
)

data class CreatedProductDto(
    val type: String,
    val id: String,
    val attributes: CreatedProductAttributes
)

data class CreatedProductAttributes(
    val productName: String,
    val productPrice: Double,
    val emoji: String,
    val businessUUID: String
)