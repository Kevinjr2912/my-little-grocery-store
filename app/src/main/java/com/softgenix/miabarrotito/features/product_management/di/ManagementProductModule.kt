package com.softgenix.miabarrotito.features.product_management.di

import com.softgenix.miabarrotito.core.di.AppContainer
import com.softgenix.miabarrotito.features.product_management.domain.usecases.GetAllProductsByBusinessUseCase
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModelFactory

class ManagementProductModule(
    private val appContainer: AppContainer) {

    private fun provideGetAllProductsByBusinessUseCase(): GetAllProductsByBusinessUseCase {
        return GetAllProductsByBusinessUseCase(appContainer.productRepository)
    }

    fun provideCharactersViewModelFactory(): ManagementProductViewModelFactory {
        return ManagementProductViewModelFactory(
            getAllProductsByBusinessUseCase = provideGetAllProductsByBusinessUseCase()
        )
    }
}