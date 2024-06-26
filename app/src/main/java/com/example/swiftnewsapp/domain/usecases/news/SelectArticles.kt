package com.example.swiftnewsapp.domain.usecases.news

import com.example.swiftnewsapp.data.local.NewsDao
import com.example.swiftnewsapp.domain.model.Article
import com.example.swiftnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

     operator fun invoke(): Flow<List<Article>>{
        return newsRepository.selectArticles()
    }
}