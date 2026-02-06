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
import com.softgenix.miabarrotito.core.navigation.NavigationWrapper
import com.softgenix.miabarrotito.features.auth.navigation.AuthNavGraph
import com.softgenix.miabarrotito.ui.theme.MiAbarrotitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val navGraphs = listOf(
            AuthNavGraph(),
        )
        setContent {
            MiAbarrotitoTheme {
                NavigationWrapper(navGraphs)
            }
        }
    }
}

