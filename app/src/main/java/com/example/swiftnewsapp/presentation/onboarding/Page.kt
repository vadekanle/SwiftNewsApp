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
        title = "lorem Ipsum is simply dummy",
        description = "lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "lorem Ipsum is simply dummy",
        description = "lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "lorem Ipsum is simply dummy",
        description = "lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding2
    )
)