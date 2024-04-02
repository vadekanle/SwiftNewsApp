package com.example.swiftnewsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: Getnews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle


)
