package com.tangwong.project.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TangWongNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.Splash.route
    ){
        composable<Screen.Splash> {
            Splash
        }
    }
}