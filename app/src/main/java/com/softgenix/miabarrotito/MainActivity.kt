package com.softgenix.miabarrotito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.softgenix.miabarrotito.features.product_management.presentation.screens.ManagementProductScreen
import com.softgenix.miabarrotito.ui.theme.MiAbarrotitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiAbarrotitoTheme {
                Column(
                    modifier = Modifier.fillMaxSize().padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ManagementProductScreen()
                }
            }
        }
    }
}
