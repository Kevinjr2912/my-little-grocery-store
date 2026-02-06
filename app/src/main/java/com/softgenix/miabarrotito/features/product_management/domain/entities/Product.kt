package com.softgenix.miabarrotito.features.product_management.domain.entities

data class Product (
    val id: String,
    val name: String,
    val price: Double,
    val category: String,
    val unit: String,
    val emoji : String
)