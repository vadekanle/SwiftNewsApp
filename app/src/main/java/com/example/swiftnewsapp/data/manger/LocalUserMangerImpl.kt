package com.example.swiftnewsapp.data.manger

import android.content.Context
import android.provider.SyncStateContract.Constants
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.swiftnewsapp.domain.manger.LocalUserManger
import com.example.swiftnewsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class LocalUserMangerImpl(
    private val context: Context
): LocalUserManger {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true

        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = com.example.swiftnewsapp.util.Constants.APP_ENTRY)
}