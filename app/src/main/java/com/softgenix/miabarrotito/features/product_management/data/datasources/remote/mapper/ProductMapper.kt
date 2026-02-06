package com.softgenix.miabarrotito.features.product_management.data.datasources.remote.mapper

import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.CreatedProductDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.ProductDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.response.UpdatedProductDto
import com.softgenix.miabarrotito.features.product_management.domain.entities.Product

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


fun UpdatedProductDto.toDomain(): Product {
    return Product(
        id = id,
        name = attributes.productName,
        price = attributes.productPrice,
        category = "",
        unit = "",
        emoji = attributes.emoji
    )
}