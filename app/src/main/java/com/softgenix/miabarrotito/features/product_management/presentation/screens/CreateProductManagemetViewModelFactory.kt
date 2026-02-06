package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CreateProductViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateProductManagementViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateProductManagementViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}