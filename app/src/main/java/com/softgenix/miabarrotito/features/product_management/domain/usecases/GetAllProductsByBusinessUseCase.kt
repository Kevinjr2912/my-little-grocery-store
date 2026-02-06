package com.softgenix.miabarrotito.features.product_management.domain.usecases

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository

class GetAllProductsByBusinessUseCase (
    private val repository: ProductRepository
) {
    suspend operator fun invoke(businessId: String): Result<List<Product>> {
        return  try {
            val products = repository.findProductsByBusiness(businessId)
            return Result.success(products)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}