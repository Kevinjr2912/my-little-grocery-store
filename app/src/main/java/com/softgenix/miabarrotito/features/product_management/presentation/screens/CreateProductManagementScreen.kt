package com.softgenix.miabarrotito.features.product_management.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.softgenix.miabarrotito.core.shared.components.AbarrotitoHeader
import com.softgenix.miabarrotito.core.shared.components.BottomBar
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductInput
import com.softgenix.miabarrotito.features.product_management.presentation.components.ProductPreviewCard
import com.softgenix.miabarrotito.features.product_management.presentation.components.StockSelector

@Composable
fun CreateProductManagementScreeen(onBackClick: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf("") }
    var stock by remember { mutableIntStateOf(10) }
    var isAvailable by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            AbarrotitoHeader(
                title = "Nuevo producto",
                canNavigateBack = true,
                onBackClick = onBackClick
            )


        }
    ) {padding  ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProductPreviewCard(name = name, price = price)
            Spacer(modifier = Modifier.height(24.dp))

            ProductInput(name, { name = it }, "Nombre del producto", Icons.Default.Inventory)
            Spacer(modifier = Modifier.height(12.dp))
            ProductInput(price, { price = it }, "Precio", Icons.Default.AttachMoney)
            Spacer(modifier = Modifier.height(12.dp))
            ProductInput(cost, { cost = it }, "Costo", Icons.Default.LocalOffer)

            Spacer(modifier = Modifier.height(24.dp))

            StockSelector(stock, onIncrease = { stock++ }, onDecrease = { if(stock > 0) stock-- })

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Disponible a venta", fontWeight = FontWeight.Bold)
                Switch(checked = isAvailable, onCheckedChange = { isAvailable = it })
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101828)),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text("GUARDAR", fontWeight = FontWeight.Bold)
            }
        }
    }
}