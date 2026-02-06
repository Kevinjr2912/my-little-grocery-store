package com.softgenix.miabarrotito.features.auth.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.miabarrotito.core.navigation.FeatureNavGraph
import com.softgenix.miabarrotito.core.navigation.Home
import com.softgenix.miabarrotito.core.navigation.Login
import com.softgenix.miabarrotito.core.navigation.Register
import com.softgenix.miabarrotito.core.navigation.StartRoute
import com.softgenix.miabarrotito.features.auth.di.AuthModule
import com.softgenix.miabarrotito.features.auth.presentation.screens.LoginScreen
import com.softgenix.miabarrotito.features.auth.presentation.screens.RegisterScreen
import com.softgenix.miabarrotito.features.auth.presentation.screens.StartScreen
import com.softgenix.miabarrotito.features.auth.presentation.viewmodels.LoginViewModel
import com.softgenix.miabarrotito.features.auth.presentation.viewmodels.RegisterViewModel
import com.softgenix.miabarrotito.features.home.presentation.screens.HomeScreen


class AuthNavGraph (private val authModule: AuthModule): FeatureNavGraph {
    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {

        navGraphBuilder.composable<Login> {
            val viewModel: LoginViewModel = viewModel(
                factory =authModule.provideLoginViewModelFactory()
            )

            LoginScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onLoginSuccess = {
                    navController.navigate(Home) {
                        popUpTo(Login) { inclusive = true }
                    }
                }
            )
        }

        navGraphBuilder.composable<StartRoute> {
            StartScreen(
                onLoginClick = { navController.navigate(Login) },
                onRegisterClick = { navController.navigate(Register) }
            )
        }

        navGraphBuilder.composable<Register> {
            val viewModel: RegisterViewModel = viewModel(
                factory = authModule.provideRegisterViewModelFactory()
            )

            RegisterScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onNavigateToLogin = {
                    navController.navigate(Login) {
                        popUpTo(Register) { inclusive = true }
                    }
                }
            )
        }
    }}