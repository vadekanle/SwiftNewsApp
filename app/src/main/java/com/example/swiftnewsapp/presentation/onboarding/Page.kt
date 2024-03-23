package com.example.swiftnewsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.swiftnewsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages= listOf(
    Page(
        title = "Welcome to Swift News App ",
        description = "Welcome to Swift News App, your go-to source for breaking news, in-depth analysis, and personalized content. Stay informed, stay connected.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Breaking News Alerts",
        description = "Never miss a beat with our real-time breaking news alerts. Whether it's politics, technology, sports, or entertainment, we'll keep you updated on the latest developments as they happen.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Personalized News Feed",
        description = "Tailor your news feed to your interests. Follow your favorite topics, sources, and journalists to curate a personalized experience. Discover new perspectives and dive deeper into the stories that matter most to you.",
        image = R.drawable.onboarding3
    )
)