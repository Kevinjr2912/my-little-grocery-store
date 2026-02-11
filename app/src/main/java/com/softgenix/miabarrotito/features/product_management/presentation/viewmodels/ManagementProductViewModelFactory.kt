package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softgenix.miabarrotito.features.product_management.domain.usecases.CreateProductUseCase
import com.softgenix.miabarrotito.features.product_management.domain.usecases.DeleteProductUseCase
import com.softgenix.miabarrotito.features.product_management.domain.usecases.GetAllProductsByBusinessUseCase

class ManagementProductViewModelFactory(
    private val getAllProductsByBusinessUseCase: GetAllProductsByBusinessUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ManagementProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ManagementProductViewModel(
                getAllProductsByBusinessUseCase,
                deleteProductUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}

class CreateProductViewModelFactory(
    private val createProductUseCase: CreateProductUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateProductViewModel(createProductUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
