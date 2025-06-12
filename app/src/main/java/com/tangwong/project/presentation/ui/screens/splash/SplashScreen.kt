package com.tangwong.project.presentation.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tangwong.project.presentation.state.SplashIntent
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun SplashScreen(viewModel: SplashViewModel = koinViewModel()) {
    LaunchedEffect(Unit) {
        val intent = SplashIntent.InitApp
        viewModel.sendIntent(intent)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
//        Image(
//            imageVector = Icons.Default.,
//            contentDescription = "splashScreen",
//            modifier = Modifier.fillMaxSize()
//        )
        TextButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { Timber.d("test click") }
        ) {
            Text("Get Start")
        }
    }
}