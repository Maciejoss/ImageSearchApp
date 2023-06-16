package com.example.imagesearchapp.feature_images_browse.domain.models

data class BasicImageInfo(
    val id: String,
    val user: String,
    val tags: String,
    val largeImageURL: String
)