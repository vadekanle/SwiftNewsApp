package com.example.swiftnewsapp.domain.usecases.news

import com.example.swiftnewsapp.data.local.NewsDao
import com.example.swiftnewsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article)
    }
}