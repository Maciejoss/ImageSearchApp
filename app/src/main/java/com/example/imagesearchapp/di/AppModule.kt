package com.example.imagesearchapp.di

import com.example.imagesearchapp.feature_images_browse.presentation.WeatherApi
import com.example.imagesearchapp.feature_images_browse.presentation.WeatherApii
import com.example.imagesearchapp.feature_images_browse.presentation.WeatherService
import com.example.imagesearchapp.feature_images_browse.data.repository.PixabayImageRepositoryImpl
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.GetImagesByTags
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImagesBrowseUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

//    @Provides
//    @Singleton
//    fun providesImagesBrowseViewModel(): ImagesBrowseViewModel {
//        return ImagesBrowseViewModel()
//    }

    @Provides
    @Singleton
    fun providesImagesBrowseUseCases(repository: PixabayImagesRepository): ImagesBrowseUseCases {
        return ImagesBrowseUseCases(getImages = GetImagesByTags(repository))
    }

    @Provides
    @Singleton
    fun providesPixabayImagesRepository(): PixabayImagesRepository {
        return PixabayImageRepositoryImpl()
    }

    @Provides
    fun providesWeatherApi(): WeatherApi {
        return WeatherApii()
    }

    @Provides
    fun providesWeatherService(api: WeatherApi): WeatherService
            = WeatherService(api)
}