package com.example.datastoredaggerhiltsample.feature_settings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Language

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Set application language")
        for(language in Language.values()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(Modifier.weight(1f))
                RadioButton(
                    selected = language == state.language,
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.onEvent(SettingsEvent.SetLanguage(language)) }
                )

                Text(
                    text = language.toString(),
                    modifier = Modifier.weight(2f),
                )
            }
        }
    }
}