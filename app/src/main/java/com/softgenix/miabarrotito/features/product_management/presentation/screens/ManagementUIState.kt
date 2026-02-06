package com.softgenix.miabarrotito.features.product_management.presentation.screens

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false,
    val selectedCategory: String? = null
)