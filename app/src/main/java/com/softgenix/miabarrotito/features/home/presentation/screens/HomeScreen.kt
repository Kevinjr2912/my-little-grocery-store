package com.softgenix.miabarrotito.features.home.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softgenix.miabarrotito.core.shared.components.AbarrotitoHeader
import com.softgenix.miabarrotito.core.shared.components.BottomBar

@Composable
fun HomeScreen(){

    Scaffold(
        topBar = {
            AbarrotitoHeader(title = "Mi abarrotería", subtitle = "Hola María",
                iconRight = null,
                canNavigateBack = false,
                onBackClick = { },
                onRightIconClick = { }
                )
        },
        bottomBar = {
            BottomBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Esto es el home")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}