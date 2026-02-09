package com.softgenix.miabarrotito.features.product_management.presentation.utils

import com.softgenix.miabarrotito.features.product_management.presentation.model.CategoryUi
import com.softgenix.miabarrotito.features.product_management.presentation.model.CategoryUiCatalog

fun categoryUiFor(categoryName: String): CategoryUi =
    CategoryUiCatalog.firstOrNull { it.key == categoryName }
        ?: CategoryUiCatalog.last() // Others