package com.example.swiftnewsapp.data.remote.datatranferobject

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.swiftnewsapp.domain.model.Article

class SearchNewsPagingSource(
    private val newsApi: NewsApi,
    private val searchQuery : String,
    private val sources: String
): PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(1 )?: anchorPage?.nextKey?.minus(1)
            }
    }
    private var totalNewsCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.searchNews(searchQuery = searchQuery, page, sources)
            totalNewsCount += newsResponse.articles.size
            val article = newsResponse.articles.distinctBy { it.title  }  //distinctBy is used for removing duplicate items from list and filter the articles
            LoadResult.Page(
                data = article,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )

        }
    }
}