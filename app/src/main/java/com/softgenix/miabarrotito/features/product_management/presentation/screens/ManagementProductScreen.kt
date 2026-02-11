package com.softgenix.miabarrotito.features.product_management.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.softgenix.miabarrotito.R
import com.softgenix.miabarrotito.core.shared.components.AbarrotitoHeader
import com.softgenix.miabarrotito.core.shared.components.BottomBar
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardCategory
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardProduct
import com.softgenix.miabarrotito.features.product_management.presentation.components.SearchBar
import com.softgenix.miabarrotito.features.product_management.presentation.model.CategoryUiCatalog
import com.softgenix.miabarrotito.features.product_management.presentation.utils.categoryUiFor
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductViewModel
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel

@Composable
fun ManagementProductScreen(
    viewModel: ManagementProductViewModel,
    onNavigateToCreateProduct: () -> Unit,
    navController: NavHostController
) {


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    Scaffold(
        topBar = {
            AbarrotitoHeader(
                title = "Artículos",
                subtitle = null,
                iconRight = ImageVector.vectorResource(id = R.drawable.tabler_icon_library_plus),
                canNavigateBack = false,
                iconLeft = null,
                onRightIconClick = { onNavigateToCreateProduct() },
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                selectedRoute = "inventory"
            )
        }
    ) {paddingValues ->

    Column(modifier = Modifier.padding(paddingValues).padding(10.dp)) {

        SearchBar()

        Spacer(modifier = Modifier.height(24.dp))

        // Header categorías
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categorías",
                style = MaterialTheme.typography.titleLarge
            )

            TextButton(
                onClick = { viewModel.onCategorySelected(null) }
            ) {
                Text("Mirar todos", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(CategoryUiCatalog) { category ->
                CardCategory(
                    icon = category.iconRes,
                    contentDescription = category.label,
                    categoryName = category.label,
                    isSelected = uiState.selectedCategory == category.key,
                    onClick = {
                        viewModel.onCategorySelected(category.key)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        when {
            uiState.isLoading -> {
                Text("Cargando...")
            }

            uiState.error != null -> {
                Text(uiState.error!!, color = Color.Red)
            }

            else -> {
                val filteredProducts =
                    uiState.selectedCategory?.let { selected ->
                        uiState.products.filter {
                            it.category == selected
                        }
                    } ?: uiState.products

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(filteredProducts.chunked(2)) { rowProducts ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            rowProducts.forEach { product ->
                                CardProduct(
                                    productName = product.name,
                                    price = product.price,
                                    unit = product.unit,
                                    icon = R.drawable.carrot,
                                    backgroundColor = categoryUiFor(product.category).color,
                                    onMenuClick = {
                                        viewModel.onProductMenuClick(product.id)
                                    }
                                )
                            }
                        }
                    }
                }

                DropdownMenu(
                    expanded = uiState.isMenuVisible,
                    onDismissRequest = { viewModel.onDismissMenu() }
                ) {
                    DropdownMenuItem(
                        text = { Text("Editar") },
                        onClick = {
                            viewModel.onDismissMenu()
                            // navegación a editar
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Eliminar") },
                        onClick = { viewModel.onDeleteProduct() }
                    )
                }
            }
        }
    }
        }
}
