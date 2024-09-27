package com.example.navegacion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController(),
    email:String? = "NO_EMAIL",
    pass:String? = "NO_PASS"
) {
    val nestedNavController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray
                ),
                    title = { Text(text = email ?: "NO_VALUE", color = Color.White) })
            },
        bottomBar = { BottomNavigationBar(nestedNavController)}
    ) { innerPadding ->

        NavHost(navController = nestedNavController, startDestination = "screenA", modifier = Modifier.padding(innerPadding)){
            composable("screenA"){ ScreenA() }
            composable("screenB"){ ScreenB() }
            composable("screenC"){ ScreenC() }
        }
    }
}


@Composable
fun BottomNavigationBar(nestedNavController: NavController = rememberNavController()){

    var navigationSelectedItemIndex by remember {
        mutableStateOf(0)
    }

    NavigationBar {
        NavigationBarItem(selected = navigationSelectedItemIndex == 0, onClick = {
            nestedNavController.navigate("screenA"){
                launchSingleTop = true
            }
            navigationSelectedItemIndex = 0
        }, icon = { Icon(Icons.Filled.Call, contentDescription = "screenA") }, label = { Text(text = "Screen A")})
        NavigationBarItem(selected = navigationSelectedItemIndex == 1, onClick = {
            nestedNavController.navigate("screenB"){
                launchSingleTop = true
            }
            navigationSelectedItemIndex = 1
        }, icon = { Icon(Icons.Filled.Check, contentDescription = "screenA") }, label = { Text(text = "Screen B")})
        NavigationBarItem(selected = navigationSelectedItemIndex == 2, onClick = {
            nestedNavController.navigate("screenC"){
                launchSingleTop = true
            }
            navigationSelectedItemIndex = 2
        }, icon = { Icon(Icons.Filled.Place, contentDescription = "screenA") }, label = { Text(text = "Screen C")})
    }
}

@Composable
fun ScreenA(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Screen A")
    }
}

@Composable
fun ScreenB(){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Logotipo")
    }
}

@Composable
fun ScreenC(){
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Cerrar sesión")
        }
    }
}