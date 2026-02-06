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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.softgenix.miabarrotito.R
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardCategory
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardProduct
import com.softgenix.miabarrotito.features.product_management.presentation.components.SearchBar
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel

@Composable
fun ManagementProductScreen(
    viewModel: ManagementProductViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.padding(16.dp)) {

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

        // Categorías estáticas (solo UI)
        val categories = listOf(
            "Vegetables",
            "Fruits",
            "Cleaning",
            "Dairy",
            "Cereals",
            "Snacks",
            "Others"
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                CardCategory(
                    icon = R.drawable.carrot,
                    contentDescription = category,
                    categoryName = category,
                    isSelected = uiState.selectedCategory == category,
                    onClick = {
                        viewModel.onCategorySelected(category)
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
                                    backgroundColor = categoryColor(product.category),
                                    onMenuClick = {}
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun categoryColor(categoryName: String): Color =
    when (categoryName) {
        "Vegetables" -> Color(0xFFA62A2A)
        "Fruits" -> Color(0xFF47B668)
        "Cleaning" -> Color(0xFFE08427)
        "Dairy" -> Color(0xFF7E47B6)
        "Cereals" -> Color(0xFF4E342E)
        "Snacks" -> Color(0xFFFF7043)
        else -> Color.Gray
    }
