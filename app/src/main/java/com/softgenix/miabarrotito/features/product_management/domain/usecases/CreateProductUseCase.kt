package com.softgenix.miabarrotito.features.product_management.domain.usecases

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository

class CreateProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(
        businessUUID: String,
        unitUUID: String,
        categoryUUID: String,
        name: String,
        price: Double,
        emoji: String
    ): Result<Product> {
        return try {
            val product = repository.createProduct(
                businessUUID,
                unitUUID,
                categoryUUID,
                name,
                price,
                emoji
            )
            Result.success(product)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
