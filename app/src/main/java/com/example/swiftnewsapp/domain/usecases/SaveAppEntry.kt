package com.example.swiftnewsapp.domain.usecases

import com.example.swiftnewsapp.domain.manger.LocalUserManger

class SaveAppEntry (
    private val localUserManger: LocalUserManger
){

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}