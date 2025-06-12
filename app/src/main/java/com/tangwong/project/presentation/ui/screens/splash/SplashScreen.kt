package com.tangwong.project.presentation.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tangwong.project.R
import com.tangwong.project.presentation.state.SplashIntent
import com.tangwong.project.presentation.ui.components.GradientButton
import com.tangwong.project.ui.theme.PrimaryGradient
import com.tangwong.project.utils.extension.safeBottomPadding
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
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.splashscreen),
            contentDescription = "splashScreen",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        GradientButton(
            text = "Get Start",
            bottomPaddingRes = R.dimen.bottom_padding_extra,
            colors = PrimaryGradient,
            widthFraction = 0.7f,
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { Timber.d("Test") }
        )
    }
}