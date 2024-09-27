package com.example.navegacion

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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.screens.LoginScreen
import com.example.navegacion.screens.ProfileScreen
import com.example.navegacion.ui.theme.NavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacionTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){ LoginScreen(navController) }
        composable("profile?email={email}&password={pass}", arguments = listOf(
            navArgument("email"){type = NavType.StringType},
            navArgument("pass"){type = NavType.StringType}
        )){ entry ->
            val email = entry.arguments?.getString("email")
            val pass = entry.arguments?.getString("pass")
            ProfileScreen(navController, email, pass)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    NavegacionTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    NavegacionTheme {
        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    NavegacionTheme {
        ProfileScreen()
    }
}