package com.softgenix.miabarrotito.features.product_management.data.repositories

import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.mapper.toDomain
import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository


class ProductRepositoryImplementation (private val api: MiAbarrotitoApi): ProductRepository {
    override suspend fun findProductsByBusiness(businessId: String): List<Product> {
        val response = api.getProductsByBusiness(businessId)
        return response.data.map { it.toDomain() }
    }
}