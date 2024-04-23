package com.example.swiftnewsapp.presentation.nvgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.swiftnewsapp.authentication.LoginScreen
import com.example.swiftnewsapp.presentation.news_navigator.components.NewsNavigator
import com.example.swiftnewsapp.presentation.nvgraph.Route.AppStartNavigation.NEWS_NAVIGATION

fun NavGraphBuilder.newsNavigationNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Route.NewsNavigatorScreen.route,
        route = NEWS_NAVIGATION
    ){

        composable(
            route = Route.NewsNavigatorScreen.route
        ){
            NewsNavigator(navController)
        }

        // Others
    }

}