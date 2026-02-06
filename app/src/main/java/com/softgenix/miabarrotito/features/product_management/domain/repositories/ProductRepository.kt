package com.softgenix.miabarrotito.features.product_management.domain.repositories

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product

interface ProductRepository {
    suspend fun createProduct(
        businessUUID: String,
        unitUUID: String,
        categoryUUID: String,
        name: String,
        price: Double,
        emoji: String
    ): Product
    suspend fun findProductsByBusiness(businessId: String): List<Product>
    suspend fun deleteProduct(productId: String): Boolean

}
