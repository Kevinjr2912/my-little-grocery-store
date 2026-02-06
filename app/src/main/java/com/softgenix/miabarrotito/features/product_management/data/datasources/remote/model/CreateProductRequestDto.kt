package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model

data class CreateProductRequestDto(
    val productUUID: String,
    val businessUUID: String,
    val unitUUID: String,
    val categoryUUID: String,
    val productName: String,
    val productPrice: Double,
    val emoji: String
)