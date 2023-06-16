package com.example.imagesearchapp.feature_images_browse.presentation.utils

sealed class Screen (val route:String) {
    object BrowseScreen: Screen("browseScreen")
    object ImageDetailsScreen: Screen("imageDetailsScreen")
}