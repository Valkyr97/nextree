package com.janyel97.nextree.di

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object CityIdParameter {
    @Provides
    @CityId
    @ViewModelScoped
    fun provideCityId(savedStateHandle: SavedStateHandle): String =
        savedStateHandle.get<String>("cityId") ?: ""
}