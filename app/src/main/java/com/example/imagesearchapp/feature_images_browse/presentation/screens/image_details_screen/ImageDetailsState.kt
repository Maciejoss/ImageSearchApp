package com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen

import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo

data class ImageDetailsState(
    val imageId: String? = null,
    val imageDetails: ExtendedImageInfo? = null
)