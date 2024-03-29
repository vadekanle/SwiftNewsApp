package com.example.swiftnewsapp.presentation.bookmark

import com.example.swiftnewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
