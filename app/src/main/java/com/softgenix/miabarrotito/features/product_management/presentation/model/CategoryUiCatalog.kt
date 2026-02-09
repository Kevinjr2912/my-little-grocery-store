package com.softgenix.miabarrotito.features.product_management.presentation.model

import androidx.compose.ui.graphics.Color
import com.softgenix.miabarrotito.R

val CategoryUiCatalog = listOf(
    CategoryUi(
        key = "Vegetables",
        label = "Vegetales",
        iconRes = R.drawable.carrot,
        color = Color(0xFFA62A2A)
    ),
    CategoryUi(
        key = "Fruits",
        label = "Frutas",
        iconRes = R.drawable.tabler_icon_apple,
        color = Color(0xFF47B668)
    ),
    CategoryUi(
        key = "Cleaning",
        label = "Limpieza",
        iconRes = R.drawable.tabler_icon_spray,
        color = Color(0xFFE08427)
    ),
    CategoryUi(
        key = "Dairy",
        label = "Lácteos",
        iconRes = R.drawable.productos_lacteos,
        color = Color(0xFF7E47B6)
    ),
    CategoryUi(
        key = "Cereals",
        label = "Cereales",
        iconRes = R.drawable.cereales,
        color = Color(0xFF4E342E)
    ),
    CategoryUi(
        key = "Snacks",
        label = "Snacks",
        iconRes = R.drawable.galleta,
        color = Color(0xFFFF7043)
    ),
    CategoryUi(
        key = "Others",
        label = "Otros",
        iconRes = R.drawable.ic_launcher_foreground,
        color = Color.Gray
    )
)
