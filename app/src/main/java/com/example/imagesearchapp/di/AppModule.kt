package com.example.imagesearchapp.di

import com.example.imagesearchapp.WeatherApi
import com.example.imagesearchapp.WeatherApii
import com.example.imagesearchapp.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providesWeatherApi(): WeatherApi {
        return WeatherApii()
    }

    @Provides
    fun providesWeatherService(api: WeatherApi): WeatherService
            = WeatherService(api)
}