package com.softgenix.miabarrotito.features.product_management.data.repositories

import com.softgenix.miabarrotito.core.network.MiAbarrotitoApi
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.mapper.toDomain
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.request.CreateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.data.datasources.remote.model.request.UpdateProductRequestDto
import com.softgenix.miabarrotito.features.product_management.domain.entities.Product
import com.softgenix.miabarrotito.features.product_management.domain.repositories.ProductRepository
import java.util.UUID


class ProductRepositoryImplementation (private val api: MiAbarrotitoApi): ProductRepository {
    override suspend fun createProduct(
        businessUUID: String,
        unitUUID: String,
        categoryUUID: String,
        name: String,
        price: Double,
        emoji: String
    ): Product {
        val request = CreateProductRequestDto(
            productUUID = UUID.randomUUID().toString(),
            businessUUID = businessUUID,
            unitUUID = unitUUID,
            categoryUUID = categoryUUID,
            productName = name,
            productPrice = price,
            emoji = emoji
        )

        val response = api.createProduct(request)
        return response.data.toDomain()
    }


    override suspend fun findProductsByBusiness(businessId: String): List<Product> {
        val response = api.getProductsByBusiness(businessId)
        return response.data.map { it.toDomain() }
    }

    override suspend fun updateProduct(
        productId: String,
        name: String,
        price: Double,
        emoji: String,
        unitUUID: String,
        categoryUUID: String
    ): Product {

        val request = UpdateProductRequestDto(
            productName = name,
            productPrice = price,
            emoji = emoji,
            unitUUID = unitUUID,
            categoryUUID = categoryUUID
        )

        val response = api.updateProduct(
            productId = productId,
            body = request
        )

        return response.data.toDomain()
    }


    override suspend fun deleteProduct(productId: String): Boolean {
        val response = api.deleteProduct(productId)
        return response.isSuccessful
    }
}