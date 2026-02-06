package com.softgenix.miabarrotito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.softgenix.miabarrotito.core.di.AppContainer
import com.softgenix.miabarrotito.features.auth.di.AuthModule
import com.softgenix.miabarrotito.features.auth.navigation.AuthNavGraph
import com.softgenix.miabarrotito.features.product_management.di.ManagementProductModule
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ManagementProductScreen
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel
import com.softgenix.miabarrotito.ui.theme.MiAbarrotitoTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        val authModule = AuthModule(appContainer)
        val managementProductModule = ManagementProductModule(appContainer)

        enableEdgeToEdge()
        val navGraphs = listOf(
            AuthNavGraph(authModule),
        )
        setContent {
            MiAbarrotitoTheme {

                val managementViewModel: ManagementProductViewModel =
                    androidx.lifecycle.viewmodel.compose.viewModel(
                        factory = managementProductModule.provideCharactersViewModelFactory()
                    )

                ManagementProductScreen(
                    viewModel = managementViewModel
                )
            }
        }
    }
}

