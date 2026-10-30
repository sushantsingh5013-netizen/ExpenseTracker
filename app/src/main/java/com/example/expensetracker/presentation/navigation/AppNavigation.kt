package com.example.expensetracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.presentation.budget.BudgetScreen
import com.example.expensetracker.presentation.home.HomeScreen
import com.example.expensetracker.presentation.insight.InsightScreen
import com.example.expensetracker.presentation.setting.SettingScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ){
        composable <HomeRoute>{
            HomeScreen(
                navController
            )
        }

        composable <InsightRoute>{
            InsightScreen()
        }

        composable <BudgetRoute>{
            BudgetScreen()
        }

        composable <SettingRoute> {
            SettingScreen()
        }
    }
}