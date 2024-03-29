package com.example.swiftnewsapp.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.example.swiftnewsapp.data.local.NewsDao
import com.example.swiftnewsapp.data.local.NewsDatabase
import com.example.swiftnewsapp.data.local.NewsTypeConvertor
import com.example.swiftnewsapp.data.manger.LocalUserMangerImpl
import com.example.swiftnewsapp.data.remote.datatranferobject.NewsApi
import com.example.swiftnewsapp.data.repository.NewsRepositoryImpl
import com.example.swiftnewsapp.domain.manger.LocalUserManger
import com.example.swiftnewsapp.domain.repository.NewsRepository
import com.example.swiftnewsapp.domain.usecases.app_entry.AppEntryUseCases
import com.example.swiftnewsapp.domain.usecases.app_entry.ReadAppEntry
import com.example.swiftnewsapp.domain.usecases.app_entry.SaveAppEntry
import com.example.swiftnewsapp.domain.usecases.news.DeleteArticle
import com.example.swiftnewsapp.domain.usecases.news.Getnews
import com.example.swiftnewsapp.domain.usecases.news.NewsUseCases
import com.example.swiftnewsapp.domain.usecases.news.SearchNews
import com.example.swiftnewsapp.domain.usecases.news.SelectArticles
import com.example.swiftnewsapp.domain.usecases.news.UpsertArticle
import com.example.swiftnewsapp.util.Constants.BASE_URL
import com.example.swiftnewsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)




    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun providesNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases{
        return NewsUseCases(
            getNews = Getnews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}