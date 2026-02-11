package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.miabarrotito.features.product_management.domain.usecases.CreateProductUseCase
import com.softgenix.miabarrotito.features.product_management.presentation.screens.CreateProductUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateProductViewModel(private val createProductUseCase: CreateProductUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(CreateProductUiState())
    val uiState = _uiState.asStateFlow()


    fun onChangeName(name: String) =
        _uiState.update { it.copy(name = name)
        }

    fun onChangePrice(price: String) =
        _uiState.update {
            it.copy(price = price)
        }

    fun onChangeUnit(unitId: String) =
        _uiState.update {
            it.copy(selectedUnitId = unitId)
        }

    fun onChangeStock(stock: Int) =
        _uiState.update {
            it.copy(stock = stock)
        }

    fun saveProduct() {

        val currentState = _uiState.value
        _uiState.update { it.copy(isLoading = true) }

        val realUnitUUID = when(currentState.selectedUnitId) {
            "kg" -> "8db52821-0563-11f1-80bd-7aaffde78d0f"
            "unidad" -> "8db4c58c-0563-11f1-80bd-7aaffde78d0f"
            "mg" -> "8db53cbd-0563-11f1-80bd-7aaffde78d0f"
            else -> "8db4c58c-0563-11f1-80bd-7aaffde78d0f"
        }

        viewModelScope.launch {
            val result = createProductUseCase(
                businessUUID = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                unitUUID = realUnitUUID,
                categoryUUID = "3fa85f64-5717-4562-b3fc-2c962f66afa6",
                name = currentState.name,
                price = currentState.price.toDoubleOrNull() ?: 0.0,
                emoji = currentState.emoji
            )

            _uiState.update { state ->
                result.fold(
                    onSuccess = { state.copy(isLoading = false, isSuccess = true) },
                    onFailure = { error -> state.copy(isLoading = false, error = error.message) }
                )
            }
        }
    }
}