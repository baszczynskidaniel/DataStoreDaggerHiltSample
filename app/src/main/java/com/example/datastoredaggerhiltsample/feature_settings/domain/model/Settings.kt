package com.example.datastoredaggerhiltsample.feature_settings.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Settings(
    val language: Language = Language.ENGLISH,
)

enum class Language{
    ENGLISH,
    POLISH,
    SPANISH,
    FRENCH,
    RUSSIAN,
    SWEDISH
}

