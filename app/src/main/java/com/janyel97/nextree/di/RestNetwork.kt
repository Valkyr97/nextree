package com.janyel97.nextree.di

import com.janyel97.nextree.data.api.ApiService
import com.janyel97.nextree.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestNetwork {

    @Singleton
    @Provides
    fun provideBaseURL(): String {
        return Constants.BASE_URL
    }

    @Singleton
    @Provides
    fun provideRestAdapter(
        baseURL: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseURL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create<ApiService>()

    @Provides
    fun provideIDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}