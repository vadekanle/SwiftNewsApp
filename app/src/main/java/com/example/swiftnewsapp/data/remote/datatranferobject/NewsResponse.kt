package com.example.swiftnewsapp.data.remote.datatranferobject

import com.example.swiftnewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)