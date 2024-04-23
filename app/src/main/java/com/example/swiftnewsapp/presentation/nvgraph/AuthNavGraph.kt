package com.example.swiftnewsapp.presentation.nvgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftnewsapp.authentication.LoginScreen
import com.example.swiftnewsapp.authentication.SignUpScreen
import com.example.swiftnewsapp.presentation.nvgraph.Route.AppStartNavigation.AUTH_ROUTE

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Route.LoginScreen.route,
        route = AUTH_ROUTE
    ){

        composable(
            route = Route.LoginScreen.route
        ){
            LoginScreen(navController)
        }

        // Other authentication composable routes
        composable(
            route = Route.SignUpScreen.route
        ){
            SignUpScreen(navController)
        }

    }

}