package com.softgenix.miabarrotito.features.product_management.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.softgenix.miabarrotito.core.shared.components.AbarrotitoHeader
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductInput
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductPreviewCard
import com.softgenix.miabarrotito.features.product_management.presentation.components.StockSelector
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductManagementViewModel

@Composable
fun CreateProductManagementScreeen(
    onBackClick: () -> Unit,
    viewModel: CreateProductManagementViewModel
) {
    val context = LocalContext.current

    // Obtenemos los estados del ViewModel
    val name by viewModel.name.collectAsState()
    val price by viewModel.price.collectAsState()
    val stock by viewModel.stock.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()
    val error by viewModel.error.collectAsState()

    // Manejo de éxito
    LaunchedEffect(isSuccess) {
        if (isSuccess) {
            Toast.makeText(context, "¡Producto guardado!", Toast.LENGTH_SHORT).show()
            onBackClick()
        }
    }

    Scaffold(
        topBar = {
            AbarrotitoHeader(
                title = "Nuevo producto",
                canNavigateBack = true,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Vista previa con datos del VM
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0xFFF2F4F7)),
                contentAlignment = Alignment.Center
            ) {
                ProductPreviewCard(name = name, price = price)
            }

            Column(modifier = Modifier.padding(24.dp)) {
                // Inputs conectados al ViewModel para que el loading jale
                ProductInput(name, { viewModel.onNameChange(it) }, "Nombre", Icons.Default.Inventory)
                Spacer(modifier = Modifier.height(12.dp))
                ProductInput(price, { viewModel.onPriceChange(it) }, "Precio", Icons.Default.AttachMoney)

                Spacer(modifier = Modifier.height(24.dp))

                // Stock manejado por el VM
                StockSelector(
                    stock = stock,
                    onIncrease = { viewModel.onIncreaseStock() },
                    onDecrease = { viewModel.onDecreaseStock() }
                )

                if (error != null) {
                    Text(text = error!!, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))

                // El botón ahora sí sabe cuándo ponerse en loading
                Button(
                    onClick = { viewModel.onCreateProduct() },
                    enabled = !isLoading,
                    modifier = Modifier.fillMaxWidth().height(55.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101828)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("GUARDAR", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }
}