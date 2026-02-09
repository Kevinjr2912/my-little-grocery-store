package com.softgenix.miabarrotito.core.shared.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.softgenix.miabarrotito.R
import com.softgenix.miabarrotito.core.navigation.Home
import com.softgenix.miabarrotito.core.navigation.ProductManagement

@Composable
fun BottomBar(
    selectedRoute: String = "home",
    navController: NavHostController,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp, start = 24.dp, end = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(40.dp),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                BottomNavItem(
                    icon = Icons.Default.Home,
                    isSelected = selectedRoute == "home",
                    onClick = { navController.navigate(Home) }
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_cash),
                    isSelected = selectedRoute == "sales",
                    onClick = { navController.navigate(Home) }
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_inventory),
                    isSelected = selectedRoute == "inventory",
                    onClick = { navController.navigate(ProductManagement) }
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_stats),
                    isSelected = selectedRoute == "reports",
                    onClick = { navController.navigate(Home) }
                )

                BottomNavItem(
                    icon = Icons.Default.Person,
                    isSelected = selectedRoute == "profile",
                    onClick = { navController.navigate(Home) }
                )
            }
        }
    }
}

/* @Preview(showBackground = false)
@Composable
fun PreviewBottomBar() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFFBCC3D4))) {
        BottomBar(selectedRoute = "home")
    }
}

 */