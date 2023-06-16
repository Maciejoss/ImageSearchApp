package com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImageDetailsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val imageDataUseCases: ImageDetailsUseCases
) : ViewModel() {


    private val _state = mutableStateOf(ImageDetailsState())
    val state: State<ImageDetailsState> = _state

    fun loadImageDetails(id: String) {
        viewModelScope.launch {
            val imageDetails = imageDataUseCases.getImageById(id)
            _state.value = state.value.copy(imageDetails = imageDetails)
        }
    }
}