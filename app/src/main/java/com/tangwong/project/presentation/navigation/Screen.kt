package com.tangwong.project.presentation.navigation

private object Route{
    const val SPLASH = "splash"
    const val HOME = "home"
    const val LOGIN = "login"
}

sealed class Screen(val route: String){
    data object Splash: Screen(Route.SPLASH)
    data object Home: Screen(Route.HOME)
    data object Login: Screen(Route.LOGIN)
}