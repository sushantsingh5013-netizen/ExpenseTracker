package com.example.expensetracker.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(){
    val currentDate = remember {
        SimpleDateFormat(
            "EEEE MMM dd",
            Locale.ENGLISH
        ).format(Date())
    }

    TopAppBar(
        title = {
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = currentDate,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Good morning, Maya",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    //todo
                }
            ) {
                Icon(
                    Icons.Default.NotificationsNone,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    )
}