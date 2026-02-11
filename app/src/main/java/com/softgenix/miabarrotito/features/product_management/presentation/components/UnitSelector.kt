package com.softgenix.miabarrotito.features.product_management.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UnitSelector(
    selectedUnitId: String,
    onUnitSelected: (String) -> Unit
) {
    val units = listOf("kg", "unidad", "mg")

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Medición", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            units.forEach { unit ->
                val isSelected = unit == selectedUnitId
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            if (isSelected) Color.Black else Color.Transparent,
                            RoundedCornerShape(12.dp)
                        )
                        .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                        .clickable { onUnitSelected(unit) }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        unit,
                        color = if (isSelected) Color.White else Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}