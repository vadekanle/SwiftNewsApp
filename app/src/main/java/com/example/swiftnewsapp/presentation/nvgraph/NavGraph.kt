package com.example.swiftnewsapp.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.swiftnewsapp.presentation.nvgraph.Route.NewsNavigation.AUTH_ROUTE
import com.example.swiftnewsapp.presentation.nvgraph.Route.NewsNavigation.NEWS_NAVIGATION
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SetNavGraph(
    navController: NavHostController,
) {

    // User
    val auth = FirebaseAuth.getInstance()

//        auth
//        .signInWithEmailAndPassword("fsdmfkdf", ";sdfjdfsd")
//        .addOnCompleteListener {
//            if(it.isSuccessful){
//                //log
//            }
//            else{
//                //
//            }
//        }

    var startingPoint= AUTH_ROUTE
    if(null != auth.currentUser)
    {
        startingPoint= NEWS_NAVIGATION
    }

    NavHost(
        navController = navController,
        startDestination = startingPoint
    ) {

        // Auth graph - For login and sign up
        authNavGraph(navController)

        // News Navigation graph | Home or main application
        newsNavigationNavGraph(navController)

        // App start graph - Bottom bar navigation
        appStartNavGraph(navController)
    }
}