package com.example.swiftnewsapp.presentation.nvgraph

sealed class Route(
    val route: String
) {

    // Route grouping definitions
    val AUTH_ROUTE = "auth"
    val APP_START = "app_start"
    val NEWS_NAVIGATION = "news_navigation"

    // Routes
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object BookmarkScreen : Route(route = "bookmarksScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")
    object LoginScreen : Route(route = "loginScreen")

    object SignUpScreen : Route(route = "signupScreen")


}
