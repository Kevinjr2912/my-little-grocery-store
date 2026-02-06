package com.softgenix.miabarrotito.core.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softgenix.miabarrotito.R

@Composable
fun BottomBar(
    selectedRoute: String = "home"
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
                    isSelected = selectedRoute == "home"
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_cash),
                    isSelected = selectedRoute == "sales"
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_inventory),
                    isSelected = selectedRoute == "inventory"
                )


                BottomNavItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_stats),
                    isSelected = selectedRoute == "reports"
                )

                BottomNavItem(
                    icon = Icons.Default.Person,
                    isSelected = selectedRoute == "profile"
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