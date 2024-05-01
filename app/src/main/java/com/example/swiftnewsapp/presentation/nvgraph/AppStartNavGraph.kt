package com.example.swiftnewsapp.presentation.nvgraph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftnewsapp.authentication.LoginScreen
import com.example.swiftnewsapp.presentation.home.HomeScreen
import com.example.swiftnewsapp.presentation.nvgraph.Route.AppStartNavigation.APP_START
import com.example.swiftnewsapp.presentation.onboarding.OnBoardingScreen
import com.example.swiftnewsapp.presentation.onboarding.OnBoardingViewModel

fun NavGraphBuilder.appStartNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Route.OnBoardingScreen.route,
        route = APP_START
    ){
        composable(
            route = Route.OnBoardingScreen.route
        ){
            val viewModel: OnBoardingViewModel =  hiltViewModel()
            OnBoardingScreen(
                event = viewModel::onEvent, navController
            )
        }

        // Others
    }

}