package com.example.imagesearchapp.feature_images_browse.data.repository

import android.util.Log
import com.example.imagesearchapp.feature_images_browse.data.retrofit.ImagesApi
import com.example.imagesearchapp.feature_images_browse.data.retrofit.RetrofitHelper
import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PixabayImageRepositoryImpl :PixabayImagesRepository{

    override suspend fun getImages(tags: String): List<BasicImageInfo> {

        val imagesApi = RetrofitHelper.getInstance().create(ImagesApi::class.java)
        val result = imagesApi.getImages()

        if(result.body()==null)return emptyList();
        return result.body()!!.hits
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