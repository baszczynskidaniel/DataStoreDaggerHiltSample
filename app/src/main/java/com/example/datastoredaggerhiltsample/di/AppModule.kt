package com.example.datastoredaggerhiltsample.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.datastoredaggerhiltsample.feature_settings.domain.model.Settings
import com.example.datastoredaggerhiltsample.feature_settings.domain.repository.SettingsRepository
import com.example.datastoredaggerhiltsample.feature_settings.data.repository.SettingsRepositoryImpl
import com.example.datastoredaggerhiltsample.feature_settings.domain.use_case.GetLanguageUseCase
import com.example.datastoredaggerhiltsample.feature_settings.domain.use_case.SetLanguageUseCase
import com.example.datastoredaggerhiltsample.feature_settings.domain.use_case.SettingsUseCases
import com.example.datastoredaggerhiltsample.util.AppSerializer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


val Context.dataStore by dataStore(
    fileName = "settings.json",
    serializer = AppSerializer
)

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    // binds instance of MyUserPreferencesRepository
    @Binds
    @Singleton
    abstract fun bindUserPreferencesRepository(
        settingsRepository: SettingsRepositoryImpl
    ): SettingsRepository

    companion object {
        // provides instance of DataStore
        @Provides
        @Singleton
        fun provideUserDataStorePreferences(
            @ApplicationContext applicationContext: Context
        ): DataStore<Settings> {
            return applicationContext.dataStore
        }

        @Provides
        @Singleton
        fun provideSettingsUseCases(repository: SettingsRepository): SettingsUseCases {
            return SettingsUseCases(
                getLanguageUseCase = GetLanguageUseCase(repository),
                setLanguageUseCase = SetLanguageUseCase(repository),
            )
        }
    }

}
