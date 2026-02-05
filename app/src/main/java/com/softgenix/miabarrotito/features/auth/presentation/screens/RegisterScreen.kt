package com.softgenix.miabarrotito.features.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softgenix.miabarrotito.features.auth.presentation.components.CustomLoginInput

@Composable
fun RegisterScreen(onBackClick: () -> Unit = {}) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFBCC3D4)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {

            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF101828))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Únete hoy",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF101828),
                lineHeight = 46.sp
            )
            Text(
                text = "Registra tu negocio en segundos.",
                fontSize = 18.sp,
                color = Color(0xFF101828).copy(alpha = 0.8f),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Nombre de tu negocio",
                icon = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Nombre",
                icon = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Apellido Paterno",
                icon = Icons.Default.Person
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Correo electrónico",
                icon = Icons.Default.Email
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Número de teléfono",
                icon = Icons.Default.Phone
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = "",
                onValueChange = {},
                label = "Repetir contraseña",
                icon = Icons.Default.Lock,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101828)),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = "COMENZAR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen()
}