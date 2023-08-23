package com.example.datastoredaggerhiltsample.feature_settings.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language
import com.example.datastoredaggerhiltsample.feature_settings.domain.repository.SettingsRepository
import com.example.datastoredaggerhiltsample.feature_settings.domain.use_case.SettingsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsUseCases: SettingsUseCases,
): ViewModel() {
    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> = _state

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(
                language = settingsUseCases.getLanguageUseCase()
            )
        }
    }

    fun onEvent(event: SettingsEvent) {
        when(event) {
            is SettingsEvent.SetLanguage -> setLanguage(event.language)
        }
    }

    private fun setLanguage(
        language: Language
    ) {
        viewModelScope.launch {
            settingsUseCases.setLanguageUseCase(language)
            _state.value = state.value.copy(
                language = settingsUseCases.getLanguageUseCase()
            )
        }
    }
}