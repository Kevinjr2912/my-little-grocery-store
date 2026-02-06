package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.miabarrotito.features.product_management.domain.usecases.GetAllProductsByBusinessUseCase
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ProductsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//class ManagementProductViewModel (
//    private val getAllProductsByBusinessUseCase: GetAllProductsByBusinessUseCase
//): ViewModel() {
//    private val _uiState = MutableStateFlow(ProductsUiState())
//    val uiState = _uiState.asStateFlow()
//
//    init {
//        loadProducts()
//    }
//
//    private fun loadProducts() {
//        _uiState.update { it.copy(isLoading = true) }
//
//        viewModelScope.launch {
//            val result = getAllProductsByBusinessUseCase(businessId = " 3fa85f64-5717-4562-b3fc-2c963f66afa6")
//            _uiState.update { currentState ->
//                result.fold(
//                    onSuccess = { list ->
//                        currentState.copy(isLoading = false, products = list)
//                    },
//                    onFailure = { error ->
//                        currentState.copy(isLoading = false, error = error.message)
//                    }
//                )
//            }
//        }
//    }
//}

class ManagementProductViewModel(
    private val getAllProductsByBusinessUseCase: GetAllProductsByBusinessUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getAllProductsByBusinessUseCase(
                businessId = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
            )

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(
                            isLoading = false,
                            products = list
                        )
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                )
            }
        }
    }

    fun onCategorySelected(category: String?) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }
}


