package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.miabarrotito.features.product_management.domain.usecases.DeleteProductUseCase
import com.softgenix.miabarrotito.features.product_management.domain.usecases.GetAllProductsByBusinessUseCase
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ProductsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ManagementProductViewModel(
    private val getAllProductsByBusinessUseCase: GetAllProductsByBusinessUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
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

    fun onProductMenuClick(productId: String) {
        _uiState.update {
            it.copy(
                menuProductId = productId,
                isMenuVisible = true
            )
        }
    }

    fun onDismissMenu() {
        _uiState.update {
            it.copy(
                isMenuVisible = false,
                menuProductId = null
            )
        }
    }

    fun onDeleteProduct() {
        val productId = uiState.value.menuProductId ?: return

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = deleteProductUseCase(productId)

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { success ->
                        if (success) {
                            currentState.copy(
                                isLoading = false,
                                products = currentState.products.filterNot { it.id == productId },
                                isMenuVisible = false,
                                menuProductId = null
                            )
                        } else {
                            currentState.copy(
                                isLoading = false,
                                error = "No se pudo eliminar el producto",
                                isMenuVisible = false,
                                menuProductId = null
                            )
                        }
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.message ?: "Error al eliminar producto",
                            isMenuVisible = false,
                            menuProductId = null
                        )
                    }
                )
            }
        }
    }





}


