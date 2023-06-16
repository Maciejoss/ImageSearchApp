package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImagesBrowseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesBrowseViewModel @Inject constructor(
    private val imagesBrowseUseCases: ImagesBrowseUseCases
): ViewModel() {
    private val _state = mutableStateOf(ImagesBrowseState())
    val state: State<ImagesBrowseState> = _state

    fun onEvent(event:ImagesBrowseEvent){
        when(event){
            is ImagesBrowseEvent.SearchButtonClicked -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        images = imagesBrowseUseCases.getImages(state.value.searchString)
                    )
                }
            }
            is ImagesBrowseEvent.SearchPhraseChanged -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        searchString = event.value
                    )
                }
            }
        }
    }
}