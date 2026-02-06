package com.softgenix.miabarrotito.features.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.softgenix.miabarrotito.features.auth.presentation.components.CustomLoginInput
import com.softgenix.miabarrotito.features.auth.presentation.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onBackClick: () -> Unit = {},
    onLoginSuccess: () -> Unit
) {


    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isSuccess by viewModel.isSuccess.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    LaunchedEffect(isSuccess) {
        if (isSuccess) {
            onLoginSuccess()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFBCC3D4)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
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
                text = "Bienvenido de nuevo",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF101828),
                lineHeight = 38.sp
            )
            Text(
                text = "Inicia sesión para continuar.",
                fontSize = 18.sp,
                color = Color(0xFF101828).copy(alpha = 0.8f),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(120.dp))


            CustomLoginInput(
                value = email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = "Correo electrónico",
                icon = Icons.Default.Email
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomLoginInput(
                value = password,
                onValueChange = { viewModel.onPasswordChange(it) },
                label = "Contraseña",
                icon = Icons.Default.Lock,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(32.dp))

            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color(0xFF101828)
                )
            } else {
                Button(
                    onClick = { viewModel.onLogin() },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101828)),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text("INICIAR SESIÓN", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "¿OLVIDASTE TU CONTRASEÑA?",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFF101828)
            )
        }
    }
}