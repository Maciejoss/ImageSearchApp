package com.example.imagesearchapp.feature_images_browse.data.repository

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository

class PixabayImageRepositoryImpl :PixabayImagesRepository{
    private val personalKey = "37377299-732b54e9475b9577a01729dc5"
    private val baseApiUrl="https://pixabay.com/api/"
    private val apiKeyUrl = "${baseApiUrl}?key=${personalKey}"

    override suspend fun getImages(tags: String): List<BasicImageInfo> {
        TODO("Not yet implemented")
        return emptyList();
    }

    override suspend fun getImageInfoById(id: String): ExtendedImageInfo {
        //Todo implement real api call
        return ExtendedImageInfo(
            "url",
            "name",
            "tags",
            1,
            1,
            1
        )
    }


}