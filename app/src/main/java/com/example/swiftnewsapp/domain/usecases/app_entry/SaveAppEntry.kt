package com.example.swiftnewsapp.domain.usecases.app_entry

import com.example.swiftnewsapp.domain.manger.LocalUserManger

class SaveAppEntry (
    private val localUserManger: LocalUserManger
){

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}