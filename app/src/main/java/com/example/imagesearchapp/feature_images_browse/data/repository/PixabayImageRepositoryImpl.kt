package com.example.imagesearchapp.feature_images_browse.data.repository

import com.example.imagesearchapp.feature_images_browse.data.retrofit.ImagesApi
import com.example.imagesearchapp.feature_images_browse.data.retrofit.RetrofitHelper
import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository

class PixabayImageRepositoryImpl(private val imagesApi:ImagesApi) : PixabayImagesRepository {

    private val userid:String = "37377299-732b54e9475b9577a01729dc5"
    override suspend fun getImages(tags: String): List<BasicImageInfo> {
        val modifiedTagsString = tags.replace(" ", "+")
        val result = imagesApi.getImages(userid, modifiedTagsString)

        if (result.body() == null) return emptyList();
        return result.body()!!.hits
    }

    override suspend fun getImageDetailsById(id: String): ExtendedImageInfo {
        val result = imagesApi.getImageById(userid, id)

        return result.body()!!.hits[0]
    }


}