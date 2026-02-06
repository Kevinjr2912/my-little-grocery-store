package com.softgenix.miabarrotito.features.product_management.domain.repositories

import com.softgenix.miabarrotito.features.product_management.domain.entities.Product

interface ProductRepository {
    suspend fun findProductsByBusiness(businessId: String): List<Product>
}
