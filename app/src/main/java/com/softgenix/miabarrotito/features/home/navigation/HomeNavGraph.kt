package com.softgenix.miabarrotito.features.home.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.miabarrotito.core.navigation.FeatureNavGraph
import com.softgenix.miabarrotito.core.navigation.Home
import com.softgenix.miabarrotito.features.home.di.HomeModule
import com.softgenix.miabarrotito.features.home.presentation.screens.HomeScreen


class HomeNavGraph (private val homeModule: HomeModule): FeatureNavGraph  {
    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController){

        navGraphBuilder.composable<Home>{


            HomeScreen(navController = navController)
        }
    }
}