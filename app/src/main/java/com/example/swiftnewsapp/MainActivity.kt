package com.example.swiftnewsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.swiftnewsapp.domain.usecases.AppEntryUseCases
import com.example.swiftnewsapp.presentation.onboarding.OnBoardingScreen
import com.example.swiftnewsapp.presentation.onboarding.OnBoardingViewModel
import com.example.swiftnewsapp.ui.theme.SwiftNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()

        lifecycleScope.launch {
            useCases.readAppEntry().collect{
                Log.d("test",it.toString())
            }
        }

        setContent {
            SwiftNewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background))
                val viewModel: OnBoardingViewModel =  hiltViewModel()
                OnBoardingScreen(
                  //event = viewModel::onEvent
                )

            }
        }
    }
}

