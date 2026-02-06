package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softgenix.miabarrotito.features.product_management.domain.usecases.GetAllProductsByBusinessUseCase

class ManagementProductViewModelFactory
    (private val getAllProductsByBusinessUseCase: GetAllProductsByBusinessUseCase): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ManagementProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ManagementProductViewModel(getAllProductsByBusinessUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
