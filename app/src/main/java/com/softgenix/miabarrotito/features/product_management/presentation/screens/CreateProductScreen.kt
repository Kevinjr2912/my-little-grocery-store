package com.softgenix.miabarrotito.features.product_management.presentation.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.softgenix.miabarrotito.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.miabarrotito.core.shared.components.AbarrotitoHeader
import com.softgenix.miabarrotito.core.shared.components.BottomBar
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductInput
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductPreviewCard
import com.softgenix.miabarrotito.features.product_management.presentation.components.StockSelector
import com.softgenix.miabarrotito.features.product_management.presentation.components.UnitSelector
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductViewModel

@Composable
fun CreateProductScreen(
    onBackClick: () -> Unit,
    navController: NavHostController,
    viewModel: CreateProductViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) onBackClick()
    }

    Scaffold(
        topBar = {
            AbarrotitoHeader(
                title = "Nuevo Producto",
                subtitle = null,
                iconRight = null,
                canNavigateBack = true,
                onBackClick = { onBackClick() },
                onRightIconClick = { }
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                selectedRoute = "inventory"
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            ProductPreviewCard(
                name = uiState.name.ifBlank { "Nombre" },
                price = uiState.price.ifBlank { "0.00" }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ProductInput(
                    uiState.name,
                    { viewModel.onChangeName(it) },
                    "Nombre del producto",
                    Icons.Default.Inventory
                )
                ProductInput(
                    uiState.price,
                    { viewModel.onChangePrice(it) },
                    "Precio",
                    Icons.Default.AttachMoney
                )


                OutlinedCard(
                    onClick = { },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            if (uiState.selectedCategoryId.isEmpty()) "Seleccionar Categoría" else "Categoría Seleccionada",
                            color = Color.Gray
                        )
                        Icon(Icons.Default.ChevronRight, null)
                    }
                }

            }


            Spacer(modifier = Modifier.height(24.dp))

            UnitSelector(
                selectedUnitId = uiState.selectedUnitId,
                onUnitSelected = { viewModel.onChangeUnit(it) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            StockSelector(
                stock = uiState.stock,
                onStockChange = { viewModel.onChangeStock(it) }
            )

            Spacer(modifier = Modifier.height(32.dp))

            if (uiState.error != null) {
                Text(uiState.error!!, color = Color.Red, modifier = Modifier.padding(bottom = 8.dp))
            }

            Button(
                onClick = { viewModel.saveProduct() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                enabled = !uiState.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A1A1A)),
                shape = RoundedCornerShape(28.dp)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                } else {
                    Text("GUARDAR", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}