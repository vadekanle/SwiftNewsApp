package com.example.swiftnewsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.swiftnewsapp.data.remote.datatranferobject.NewsApi
import com.example.swiftnewsapp.data.remote.datatranferobject.NewsPagingSource
import com.example.swiftnewsapp.data.remote.datatranferobject.SearchNewsPagingSource
import com.example.swiftnewsapp.domain.model.Article
import com.example.swiftnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
            return Pager(
                config = PagingConfig(pageSize = 10),
                pagingSourceFactory = {
                    SearchNewsPagingSource(
                        searchQuery = searchQuery,
                        newsApi = newsApi,
                        sources = sources.joinToString(separator = ",")
                    )
                }
            ).flow
    }
}