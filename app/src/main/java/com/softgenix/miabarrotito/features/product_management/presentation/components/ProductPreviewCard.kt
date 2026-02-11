package com.softgenix.miabarrotito.features.product_management.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.miabarrotito.R

@Composable
fun ProductPreviewCard(name: String, price: String) {
    Card(
        modifier = Modifier
            .size(160.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA62A2A))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector =ImageVector.vectorResource(id = R.drawable.tabler_icon_library_plus),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(48.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text("$ $price", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
        }
    }
}