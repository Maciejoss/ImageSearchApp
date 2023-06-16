package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo

sealed class ImagesBrowseEvent {
    data class SearchPhraseChanged(val value:String) :ImagesBrowseEvent()
    data class SearchButtonClicked(val search:Boolean=true) :ImagesBrowseEvent()
}