package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.request

data class UpdateProductRequestDto(
    val productName: String,
    val productPrice: Double,
    val emoji: String,
    val unitUUID: String,
    val categoryUUID: String
)