package com.softgenix.miabarrotito.features.product_management.presentation.screens

data class CreateProductUiState(
    val name: String = "",
    val price: String = "",
    val cost: String = "",
    val selectedUnitId: String = "kg",
    val selectedCategoryId: String = "",
    val emoji: String = "🍎",
    val stock: Int = 10,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)