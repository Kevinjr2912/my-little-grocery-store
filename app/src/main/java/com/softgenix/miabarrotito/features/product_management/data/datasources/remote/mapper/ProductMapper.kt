package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.mapper

import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.CreateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.CreatedProductDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.ProductDto
import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import java.util.UUID

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        name = attributes.productName,
        price = attributes.productPrice.toDouble(),
        category = attributes.category.name,
        unit = attributes.unit.abbreviation,
        emoji = attributes.emoji
    )
}

fun CreatedProductDto.toDomain(): Product {
    return Product(
        id = id,
        name = attributes.productName,
        price = attributes.productPrice,
        category = "",
        unit = "",
        emoji = attributes.emoji
    )
}