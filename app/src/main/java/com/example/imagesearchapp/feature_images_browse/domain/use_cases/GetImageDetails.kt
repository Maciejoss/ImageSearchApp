package com.example.imagesearchapp.feature_images_browse.domain.use_cases

import com.example.imagesearchapp.feature_images_browse.domain.models.ExtendedImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository

class GetImageDetailsById(
    private val repository: PixabayImagesRepository
) {
    suspend operator fun invoke(id: String): ExtendedImageInfo {
        return repository.getImageDetailsById(id)
    }
}