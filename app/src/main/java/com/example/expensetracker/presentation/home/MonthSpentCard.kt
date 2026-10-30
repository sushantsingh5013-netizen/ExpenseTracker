package com.example.expensetracker.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun MonthSpentCard() {
    val month = remember {
        SimpleDateFormat(
            "MMMM",
            Locale.ENGLISH
        ).format(Date())
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF4CAF50),
                        Color(0xFFCDDC39)
                    )
                ))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "$month spending",
                fontSize = 14.sp,
                color = Color(0xFFEAE5E5),
                fontWeight = FontWeight.W600
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "$2,420.90",
                color = Color(0xFFEAE5E5),
                fontSize = 32.sp,
                fontWeight = FontWeight.W900
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$2,420 spent",
                    color = Color(0xFFEAE5E5),
                    fontWeight = FontWeight.W600
                )
                Text(
                    text = "$3,500 budget",
                    fontWeight = FontWeight.W600,
                    color = Color(0xFFEAE5E5)
                )
            }
        }
    }
}