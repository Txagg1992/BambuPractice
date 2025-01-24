package com.curiousapps.bambupractice.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.bambupractice.domain.BamItem
import com.curiousapps.bambupractice.ui.presentation.BamViewModel.BamState


@Composable
fun BamListScreen(
    viewModel: BamViewModel = hiltViewModel()
){

    val state = viewModel.state.collectAsState(initial = BamState())
    val bam = state.value.bamList

    GradientBackground()
    if (state.value.isLoading){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(80.dp, 80.dp),
                color = Color.White,
                trackColor = Color.Transparent
            )
        }
    }else{
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 32.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val itemCount = bam.size
                items(itemCount){ index ->
                    BamRow(bamItem = bam[index])
                }
            }
        }
    }
}

@Composable
fun BamRow(
    bamItem: BamItem
){

    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = bamItem.title,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bamItem.subtitle,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
        Divider(
            modifier = Modifier.height(2.dp)
                .padding(start = 40.dp, end = 40.dp),
            color = Color.LightGray
        )
    }
}

@Composable
fun GradientBackground() {
    val gradient = Brush.linearGradient(
        0.0f to Color.LightGray,
        500.0f to Color.Blue,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient).fillMaxSize())
}