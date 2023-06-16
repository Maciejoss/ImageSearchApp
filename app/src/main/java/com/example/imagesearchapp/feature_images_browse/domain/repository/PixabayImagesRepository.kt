package com.example.imagesearchapp.feature_images_browse.domain.repository

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo

interface PixabayImagesRepository {

    suspend fun getImages(tags:String):List<BasicImageInfo>

    suspend fun getImageInfoById(id:String):ExtendedImageInfo

}