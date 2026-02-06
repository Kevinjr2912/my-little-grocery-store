package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response

data class UpdateProductResponseDto(
    val data: UpdatedProductDto
)

data class UpdatedProductDto(
    val type: String,
    val id: String,
    val attributes: UpdatedProductAttributes
)

data class UpdatedProductAttributes(
    val productName: String,
    val productPrice: Double,
    val emoji: String
)
