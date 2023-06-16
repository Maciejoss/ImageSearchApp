package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo

sealed class ImagesBrowseEvent {
    data class Search(val tags: String):ImagesBrowseEvent()
    data class SelectImage(val imageInfo: BasicImageInfo):ImagesBrowseEvent()
}