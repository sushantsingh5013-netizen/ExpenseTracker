package com.example.expensetracker.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.presentation.components.BottomNavigationBar

@Composable
fun HomeScreen(
    navController : NavHostController
){
    Scaffold(
        modifier = Modifier.background(Color(0xFFEEEEEE)),
        topBar = {
            HomeTopBar()
        },
        bottomBar = {
            BottomNavigationBar(
                navController
            )
        }
    ) {
        innerPadding->
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchBar()
            MonthSpentCard()
//            ExpenseDonutChart()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    HomeScreen(navController)
}