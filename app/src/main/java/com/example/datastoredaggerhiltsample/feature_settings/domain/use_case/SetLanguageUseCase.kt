package com.example.datastoredaggerhiltsample.feature_settings.domain.use_case

import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language
import com.example.datastoredaggerhiltsample.feature_settings.domain.repository.SettingsRepository

class SetLanguageUseCase (
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(language: Language) {
        repository.setLanguage(language)
    }
}