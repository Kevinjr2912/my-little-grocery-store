package com.softgenix.miabarrotito.features.product_management.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CreateProductManagementViewModel : ViewModel() { // <-- Ya no pide nada en el constructor

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _price = MutableStateFlow("")
    val price = _price.asStateFlow()

    private val _stock = MutableStateFlow(10)
    val stock = _stock.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess = _isSuccess.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun onNameChange(newValue: String) { _name.value = newValue }
    fun onPriceChange(newValue: String) { _price.value = newValue }
    fun onIncreaseStock() { _stock.value++ }
    fun onDecreaseStock() { if (_stock.value > 0) _stock.value-- }

    fun onCreateProduct() {
        if (_name.value.isBlank() || _price.value.isBlank()) {
            _error.value = "¡Llena los campos, we!"
            return
        }

        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            delay(1000) // Simula que está guardando
            _isLoading.value = false
            _isSuccess.value = true // Esto te regresa a la pantalla anterior
        }
    }
}