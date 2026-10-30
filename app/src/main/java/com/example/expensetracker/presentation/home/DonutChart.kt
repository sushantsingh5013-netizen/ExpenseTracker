package com.example.expensetracker.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patrykandpatrick.vico.compose.common.Fill
import com.patrykandpatrick.vico.compose.pie.PieChart
import com.patrykandpatrick.vico.compose.pie.PieChartHost
import com.patrykandpatrick.vico.compose.pie.PieSize
import com.patrykandpatrick.vico.compose.pie.data.PieChartModelProducer
import com.patrykandpatrick.vico.compose.pie.data.pieModel
import com.patrykandpatrick.vico.compose.pie.rememberPieChart

@Preview(showBackground = true)
@Composable
fun DonutChart(
    modifier : Modifier = Modifier
){
    val modelProducer = remember {
        PieChartModelProducer()
    }

    LaunchedEffect(Unit) {
        modelProducer.runTransaction {
            pieModel {
                series(36, 24, 22, 18)
            }
        }
    }

    val chartColors = listOf(
        Color(0xFFFF6B57), // Food
        Color(0xFF9060E8), // Transport
        Color(0xFF4169E1), // Bills
        Color(0xFF55BBA8)  // Other
    )

    val chart = rememberPieChart(
        sliceProvider = PieChart.SliceProvider.series(
            chartColors.map { color ->
                PieChart.Slice(
                    fill = Fill(color)
                )
            }
        ),
        innerSize = PieSize.Inner.fixed(325.dp),
        startAngle = -90f
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        PieChartHost(
            chart = chart,
            modelProducer = modelProducer,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Spent",
                fontSize = 12.sp
            )

            Text(
                text = "$2,420",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF17243A)
            )
        }
    }
}