package com.example.swiftnewsapp.domain.usecases.news

import com.example.swiftnewsapp.data.local.NewsDao
import com.example.swiftnewsapp.domain.model.Article
import com.example.swiftnewsapp.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}