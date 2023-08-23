package com.example.datastoredaggerhiltsample.feature_settings.presentation

import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language

sealed class SettingsEvent {
    data class SetLanguage(val language: Language): SettingsEvent()
}
