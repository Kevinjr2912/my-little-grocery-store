package com.softgenix.miabarrotito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softgenix.miabarrotito.core.di.AppContainer
import com.softgenix.miabarrotito.core.navigation.NavigationWrapper
import com.softgenix.miabarrotito.features.auth.di.AuthModule
import com.softgenix.miabarrotito.features.auth.navigation.AuthNavGraph
import com.softgenix.miabarrotito.features.home.di.HomeModule
import com.softgenix.miabarrotito.features.home.navigation.HomeNavGraph
import com.softgenix.miabarrotito.features.product_management.di.ManagementProductModule
import com.softgenix.miabarrotito.features.product_management.navigation.ProductManagementNavGraph
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ManagementProductScreen
import com.softgenix.miabarrotito.features.product_management.presentation.viewmodels.ManagementProductViewModel
import com.softgenix.miabarrotito.ui.theme.MiAbarrotitoTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        val authModule = AuthModule(appContainer)
        val homeModule = HomeModule(appContainer)

        val managementProductModule = ManagementProductModule(appContainer)


        enableEdgeToEdge()
        val navGraphs = listOf(
            AuthNavGraph(authModule),
            HomeNavGraph(homeModule),
            ProductManagementNavGraph(managementProductModule)
        )
        setContent {
            MiAbarrotitoTheme {
                NavigationWrapper(navGraphs)

            }
        }
    }
}