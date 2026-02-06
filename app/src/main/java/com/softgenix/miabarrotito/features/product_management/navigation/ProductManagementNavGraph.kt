package com.softgenix.miabarrotito.features.product_management.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.miabarrotito.core.navigation.FeatureNavGraph
import com.softgenix.miabarrotito.core.navigation.ProductManagement
import com.softgenix.miabarrotito.core.navigation.CreateProduct
import com.softgenix.miabarrotito.features.product_management.di.ManagementProductModule
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel
import com.softgenix.miabarrotito.features.product_management.presentation.screens.CreateProductManagementScreeen
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ManagementProductScreen
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductManagementViewModel
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductViewModelFactory

class ProductManagementNavGraph(private val managementProductModule: ManagementProductModule) :
    FeatureNavGraph {
    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {

        navGraphBuilder.composable<ProductManagement> {
            val viewModel: ManagementProductViewModel =
                viewModel(factory = managementProductModule.provideCharactersViewModelFactory())
            ManagementProductScreen(
                viewModel = viewModel,
                onNavigateToCreate = { navController.navigate(CreateProduct) }
            )
        }

        navGraphBuilder.composable<CreateProduct> {
            val createVm: CreateProductManagementViewModel = viewModel(

                factory = CreateProductViewModelFactory()
            )

            CreateProductManagementScreeen(
                viewModel = createVm,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}