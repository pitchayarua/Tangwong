package com.tangwong.project.di

import com.tangwong.project.presentation.ui.screens.splash.SplashViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

var viewModelModule = module {
    singleOf(::SplashViewModel)
}