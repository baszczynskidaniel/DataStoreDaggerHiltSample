package com.example.datastoredaggerhiltsample.feature_settings.domain.repository

import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language

interface SettingsRepository {
    suspend fun setLanguage(
        language: Language
    )
    suspend fun getLanguage(): Language
}