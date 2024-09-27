package com.example.navegacion.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(navController: NavController = rememberNavController()) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(1f))
        TextField(value = email, onValueChange = {email = it})
        TextField(value = password, onValueChange = {password = it}, visualTransformation = PasswordVisualTransformation())
        Button(onClick = {
            val options = NavOptions.Builder().setPopUpTo(route = "login", inclusive = true).build()
            navController.navigate("profile?email=$email&password=$password", options)
        }) {
            Text("Iniciar Sesión")
        }
        Box(modifier = Modifier.weight(1f))
    }
}