package com.example.imagesearchapp.feature_images_browse.domain.models

data class ExtendedImageInfo(
    val largeImageURL: String,
    val user: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
)