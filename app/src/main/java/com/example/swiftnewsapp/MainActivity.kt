package com.example.swiftnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.swiftnewsapp.app.SwiftNewsApp
import com.example.swiftnewsapp.presentation.nvgraph.SetNavGraph
import com.example.swiftnewsapp.ui.theme.SwiftNewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>() // Initialize ViewModel using Hilt
    private lateinit var navController: NavHostController // Initialize NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set system window attributes
        WindowCompat.setDecorFitsSystemWindows(window,false)

        // Install splash screen and set its keep on screen condition
        installSplashScreen().setKeepOnScreenCondition() { false }


        setContent {
            SwiftNewsApp()
            SwiftNewsAppTheme {


                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,

                    )
                }
                // Initialize NavHostController
                navController = rememberNavController()

                // Set up the UI with NavHost and specified navigation graph
                Box(modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxHeight())
                {
                    SetNavGraph(navController)
                }

            }
        }
    }
}


