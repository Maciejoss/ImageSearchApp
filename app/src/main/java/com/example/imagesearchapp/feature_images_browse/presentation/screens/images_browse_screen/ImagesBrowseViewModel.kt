package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class ImagesBrowseViewModel @Inject constructor()
    : ViewModel() {
    private val _state = mutableStateOf(ImagesBrowseState())
    val state: State<ImagesBrowseState> = _state
    private var getImageJob: Job? = null
}