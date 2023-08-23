package com.example.datastoredaggerhiltsample.feature_settings.presentation

import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language

data class SettingsState (
    val language: Language = Language.ENGLISH
)