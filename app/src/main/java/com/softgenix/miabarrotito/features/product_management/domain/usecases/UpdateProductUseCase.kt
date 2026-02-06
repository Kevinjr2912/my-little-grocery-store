package com.softgenix.miabarrotito.features.product_management.domain.usecases

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository

class UpdateProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(
        productId: String,
        name: String,
        price: Double,
        emoji: String,
        unitUUID: String,
        categoryUUID: String
    ): Result<Product> {
        return try {
            val updatedProduct = repository.updateProduct(
                productId = productId,
                name = name,
                price = price,
                emoji = emoji,
                unitUUID = unitUUID,
                categoryUUID = categoryUUID
            )
            Result.success(updatedProduct)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
