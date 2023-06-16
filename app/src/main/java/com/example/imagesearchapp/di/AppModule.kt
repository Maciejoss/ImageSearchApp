package com.example.imagesearchapp.di

import com.example.imagesearchapp.feature_images_browse.data.repository.PixabayImageRepositoryImpl
import com.example.imagesearchapp.feature_images_browse.data.retrofit.ImagesApi
import com.example.imagesearchapp.feature_images_browse.data.retrofit.RetrofitHelper
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.GetImageDetailsById
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.GetImagesByTags
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImageDetailsUseCases
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImagesBrowseUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesImagesBrowseUseCases(repository: PixabayImagesRepository): ImagesBrowseUseCases {
        return ImagesBrowseUseCases(getImages = GetImagesByTags(repository))
    }

    @Provides
    @Singleton
    fun providesImageDetailsUseCases(repository: PixabayImagesRepository): ImageDetailsUseCases {
        return ImageDetailsUseCases(getImageById = GetImageDetailsById(repository))
    }

    @Provides
    @Singleton
    fun providesPixabayImagesRepository(imagesApi: ImagesApi): PixabayImagesRepository {
        return PixabayImageRepositoryImpl(imagesApi)
    }

    @Provides
    @Singleton
    fun providesImagesApi(): ImagesApi {
        return RetrofitHelper.getInstance().create(ImagesApi::class.java)
    }

}