package com.example.swiftnewsapp.domain.usecases

import com.example.swiftnewsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
){

    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManger.readAppEntry()
    }
}
