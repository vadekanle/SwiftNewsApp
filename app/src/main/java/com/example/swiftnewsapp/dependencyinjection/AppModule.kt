package com.example.swiftnewsapp.dependencyinjection

import android.app.Application
import com.example.swiftnewsapp.data.manger.LocalUserMangerImpl
import com.example.swiftnewsapp.domain.manger.LocalUserManger
import com.example.swiftnewsapp.domain.usecases.AppEntryUseCases
import com.example.swiftnewsapp.domain.usecases.ReadAppEntry
import com.example.swiftnewsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}