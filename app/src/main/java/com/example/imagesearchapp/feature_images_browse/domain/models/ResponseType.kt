package com.example.imagesearchapp.feature_images_browse.domain.models

data class ResponseType<T>(
    val hits: List<T>,
)
