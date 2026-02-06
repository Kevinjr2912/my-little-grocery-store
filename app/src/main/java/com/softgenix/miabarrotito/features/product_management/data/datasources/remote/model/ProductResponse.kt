package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model

data class ProductResponseDto (
    val data: List<ProductDto>
)

data class ProductDto(
    val type: String,
    val id: String,
    val attributes: ProductAttributes
)

data class ProductAttributes(
    val productName: String,
    val productPrice: String,
    val emoji: String,
    val unit: UnitDto,
    val category: CategoryDto
)

data class UnitDto(
    val id: String,
    val abbreviation: String
)

data class CategoryDto(
    val id: String,
    val name: String
)

