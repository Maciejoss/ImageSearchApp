package com.example.imagesearchapp.feature_images_browse.domain.models

data class ExtendedImageInfo(
    val bigImageUrl : String,
    val userName:String,
    val tags: String,
    val numberOfLikes: Int,
    val numberOfDownloads: Int,
    val numberOfComments: Int,
    )