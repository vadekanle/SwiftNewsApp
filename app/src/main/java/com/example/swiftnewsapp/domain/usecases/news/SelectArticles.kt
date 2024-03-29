package com.example.swiftnewsapp.domain.usecases.news

import com.example.swiftnewsapp.data.local.NewsDao
import com.example.swiftnewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsDao: NewsDao
) {

     operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }
}