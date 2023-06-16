package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo

data class ImagesBrowseState (
    val searchString:String = "fruits",
    val images: List<BasicImageInfo> = emptyList(),
)