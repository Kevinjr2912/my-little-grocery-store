package com.softgenix.miabarrotito.features.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.softgenix.miabarrotito.core.navigation.FeatureNavGraph
import com.softgenix.miabarrotito.core.navigation.Login
import com.softgenix.miabarrotito.core.navigation.Register
import com.softgenix.miabarrotito.core.navigation.StartRoute
import com.softgenix.miabarrotito.features.auth.presentation.screens.LoginScreen
import com.softgenix.miabarrotito.features.auth.presentation.screens.RegisterScreen
import com.softgenix.miabarrotito.features.auth.presentation.screens.StartScreen


class AuthNavGraph : FeatureNavGraph {
    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<Login> {

            LoginScreen(
                onBackClick = {
                    navController.navigate(Register)
                }
            )
        }

        navGraphBuilder.composable<Login> {
            LoginScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        navGraphBuilder.composable<StartRoute> {
            StartScreen(
                onLoginClick = { navController.navigate(Login) },
                onRegisterClick = { navController.navigate(Register) }
            )
        }

        navGraphBuilder.composable<Register> {
            RegisterScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        }
    }