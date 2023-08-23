package com.example.datastoredaggerhiltsample.feature_settings.data.repository

import androidx.datastore.core.DataStore
import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language
import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Settings
import com.example.datastoredaggerhiltsample.feature_settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val settings: DataStore<Settings>,

): SettingsRepository {
    override suspend fun getLanguage(): Language {
        return settings.data.map {
            it.language
        }.first()
    }

    override suspend fun setLanguage(language: Language) {
        Result.runCatching {
            settings.updateData {
                it.copy(
                    language = language
                )
            }
        }
    }
}