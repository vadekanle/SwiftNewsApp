package com.example.swiftnewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.swiftnewsapp.domain.model.Article
import com.example.swiftnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class Getnews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)

    }
}