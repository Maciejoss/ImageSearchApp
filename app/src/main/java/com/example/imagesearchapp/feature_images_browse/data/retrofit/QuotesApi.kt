package com.example.imagesearchapp.feature_images_browse.data.retrofit

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ResponseType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {
    @GET("?key=37377299-732b54e9475b9577a01729dc5&q=yellow+flowers&image_type=photo")
    suspend fun getImages() : Response<ResponseType>
}