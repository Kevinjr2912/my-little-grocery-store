package com.softgenix.miabarrotito.features.product_management.domain.usecases

import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository

class DeleteProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: String): Result<Boolean> {
        return try {
            val success = repository.deleteProduct(productId)
            Result.success(success)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
