package com.example.imagesearchapp.feature_images_browse.data.retrofit

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.models.ResponseType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {
    @GET(".")
    suspend fun getImages(@Query("key") key:String,@Query("q") tags:String) : Response<ResponseType<BasicImageInfo>>

    @GET(".")
    suspend fun getImageById(@Query("key") key:String,@Query("id") tags:String) : Response<ResponseType<ExtendedImageInfo>>
}