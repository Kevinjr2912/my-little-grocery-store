package com.softgenix.miabarrotito.features.product_management.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.miabarrotito.core.navigation.CreateProduct
import com.softgenix.miabarrotito.core.navigation.FeatureNavGraph
import com.softgenix.miabarrotito.core.navigation.Home
import com.softgenix.miabarrotito.core.navigation.ProductManagement
import com.softgenix.miabarrotito.features.product_management.di.ManagementProductModule
import com.softgenix.miabarrotito.features.product_management.presentation.screens.CreateProductScreen
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ManagementProductScreen
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.CreateProductViewModel
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel

class ProductManagementNavGraph(private val managementProductModule: ManagementProductModule) :
    FeatureNavGraph {
    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<ProductManagement> {
            val viewModel: ManagementProductViewModel =
                viewModel(factory = managementProductModule.provideCharactersViewModelFactory())
            ManagementProductScreen(
                viewModel = viewModel,
                onNavigateToCreateProduct = { navController.navigate(CreateProduct) },
                navController
            )
        }

        navGraphBuilder.composable<CreateProduct>{
            val createViewModel: CreateProductViewModel = viewModel(
                factory = managementProductModule.provideCreateProductViewModelFactory()
            )
            CreateProductScreen (
                onBackClick = { navController.popBackStack() },
                navController,
                viewModel = createViewModel,
            )

        }

//        navGraphBuilder.composable<EditProduct>{
//            val viewModel: ManagementProductViewModel=
//                viewModel(factory = managementProductModule.provideCharactersViewModelFactory())
//
//            CreateProductScreen (
//                onBackClick = { navController.popBackStack() }
//            )
//
//        }
    }
}
