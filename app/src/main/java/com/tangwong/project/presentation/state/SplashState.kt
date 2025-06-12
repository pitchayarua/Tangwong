package com.tangwong.project.presentation.state

sealed interface SplashIntent {
    data object InitApp : SplashIntent
}

sealed interface SplashState {
    data object Idle : SplashState
    data object Loading : SplashState
    data class Success(val data: Boolean) : SplashState
}

sealed interface SplashEffect {
    data object NavigateToLogin : SplashEffect
}