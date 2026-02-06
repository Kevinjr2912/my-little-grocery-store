package com.softgenix.miabarrotito.features.product_management.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softgenix.miabarrotito.R
import com.softgenix.miabarrotito.features.product_management.domain.entities.Category
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardCategory
import com.softgenix.miabarrotito.features.product_management.presentation.components.CardProduct
import com.softgenix.miabarrotito.features.product_management.presentation.components.SearchBar

@Preview(showBackground = true)
@Composable
fun ManagementProductScreen() {
    var selectedCategoryId by remember { mutableStateOf(1) }

    val categories = listOf(
        Category(1, "Vegetales", R.drawable.carrot),
        Category(2, "Frutas", R.drawable.tabler_icon_apple),
        Category(3, "Limpieza", R.drawable.tabler_icon_spray),
        Category(4, "Lácteos", R.drawable.productos_lacteos),
        Category(5, "Cereales", R.drawable.cereales),
        Category(6, "Frituras", R.drawable.galleta),
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        SearchBar()

        Spacer(modifier = Modifier.height(24.dp))

        // Header de Categorías
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categorías",
                style = MaterialTheme.typography.titleLarge
            )

            TextButton(onClick = {}) {
                Text(
                    text = "Mirar todos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Carrusel de categorías
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(categories) { category ->
                CardCategory(
                    icon = category.icon,
                    contentDescription = category.name,
                    categoryName = category.name,
                    isSelected = selectedCategoryId == category.id,
                    onClick = { selectedCategoryId = category.id }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CardProduct(
                        productName = "Aguacate",
                        price = "$ 85 kg",
                        icon = R.drawable.carrot,
                        backgroundColor = Color(0xFFA62A2A),
                        onMenuClick = {}
                    )

                    CardProduct(
                        productName = "Manzana",
                        price = "$ 45 kg",
                        icon = R.drawable.carrot,
                        backgroundColor = Color(0xFF47B668),
                        onMenuClick = {}
                    )

                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CardProduct(
                        productName = "Aguacate",
                        price = "$ 85 kg",
                        icon = R.drawable.carrot,
                        backgroundColor = Color(0xFFE08427),
                        onMenuClick = {}
                    )

                    CardProduct(
                        productName = "Manzana",
                        price = "$ 45 kg",
                        icon = R.drawable.carrot,
                        backgroundColor = Color(0xFF7E47B6),
                        onMenuClick = {}
                    )

                }
            }
        }


    }
}