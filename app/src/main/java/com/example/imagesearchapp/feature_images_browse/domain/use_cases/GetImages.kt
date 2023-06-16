package com.example.imagesearchapp.feature_images_browse.domain.use_cases

import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.domain.repository.PixabayImagesRepository

class GetImagesByTags(
    private val repository:PixabayImagesRepository
) {
    suspend operator fun invoke(tags:String):List<BasicImageInfo>{
        return repository.getImages(tags)
    }
}