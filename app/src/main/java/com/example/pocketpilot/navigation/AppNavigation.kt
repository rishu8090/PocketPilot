package com.example.pocketpilot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pocketpilot.AddExpense
import com.example.pocketpilot.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "/home"
    ) {
        composable(
            route = "/home"
        ) {
            HomeScreen(navController = navController)
        }


        composable(
            route =  "/add"
        ){
            AddExpense(navController = navController)
        }
    }
}