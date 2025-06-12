package com.tangwong.project.presentation.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tangwong.project.presentation.state.SplashEffect
import com.tangwong.project.presentation.state.SplashIntent
import com.tangwong.project.presentation.state.SplashState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class SplashViewModel() : ViewModel() {


    private val splashIntent = MutableSharedFlow<SplashIntent>()

    private val _splashState = MutableStateFlow(SplashState.Idle)
    val splashState = _splashState.asStateFlow()
    private val _splashEffect = Channel<SplashEffect>(Channel.BUFFERED)
    val splashEffect = _splashEffect.receiveAsFlow()
    init {
        Timber.d("test Init Splash")
    }
    fun sendIntent(intent:  SplashIntent) {
        viewModelScope.launch {
            splashIntent.emit(intent)
        }
    }
}