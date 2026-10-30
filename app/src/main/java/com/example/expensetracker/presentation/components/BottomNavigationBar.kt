package com.example.expensetracker.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.expensetracker.R
import com.example.expensetracker.presentation.navigation.BudgetRoute
import com.example.expensetracker.presentation.navigation.HomeRoute
import com.example.expensetracker.presentation.navigation.InsightRoute
import com.example.expensetracker.presentation.navigation.SettingRoute

@Composable
fun BottomNavigationBar(
    navController : NavHostController
){
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val destination = navBackStackEntry?.destination

        NavigationBarItem(
            selected = destination?.route == HomeRoute::class.qualifiedName,
            onClick = {
                navController.navigate(HomeRoute) {
                    popUpTo<HomeRoute> {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.outline_home_24),
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFF6B57),
                selectedTextColor = Color(0xFFFF6B57),
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = destination?.route == InsightRoute::class.qualifiedName,
            onClick = {
                navController.navigate(InsightRoute) {
                    popUpTo<InsightRoute> {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.outline_insights_24),
                    contentDescription = "Insight"
                )
            },
            label = {
                Text("Insight")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFF6B57),
                indicatorColor = Color.Transparent,
                selectedTextColor = Color(0xFFFF6B57),
            )
        )
        NavigationBarItem(
                selected = destination?.route == BudgetRoute::class.qualifiedName,
        onClick = {
            navController.navigate(BudgetRoute) {
                popUpTo<BudgetRoute> {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        icon = {
            Icon(
                painter = painterResource(R.drawable.outline_account_balance_wallet_24),
                contentDescription = "Budget icon"
            )
        },
        label = {
            Text("Budget")
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color(0xFFFF6B57),
            selectedTextColor = Color(0xFFFF6B57),
            indicatorColor = Color.Transparent
        )
        )
        NavigationBarItem(
            selected = destination?.route == SettingRoute::class.qualifiedName,
            onClick = {
                navController.navigate(SettingRoute) {
                    popUpTo<SettingRoute> {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.outline_home_24),
                    contentDescription = "Setting"
                )
            },
            label = {
                Text("Setting")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFFF6B57),
                selectedTextColor = Color(0xFFFF6B57),
                indicatorColor = Color.Transparent
            )
        )
    }
}
