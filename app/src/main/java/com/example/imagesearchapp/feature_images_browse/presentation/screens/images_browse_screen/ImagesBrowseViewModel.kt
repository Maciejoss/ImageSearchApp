package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.feature_images_browse.domain.use_cases.ImagesBrowseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesBrowseViewModel @Inject constructor(
    private val imagesBrowseUseCases: ImagesBrowseUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ImagesBrowseState())
    val state: State<ImagesBrowseState> = _state

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()

    fun onOpenDialogClicked() {
        _showDialog.value = true
    }

    fun onDialogConfirm() {
        _showDialog.value = false
        // Continue with executing the confirmed action
    }

    fun onDialogDismiss() {
        _showDialog.value = false
    }

    init {
        getImages()
    }

    fun onEvent(event: ImagesBrowseEvent) {
        when (event) {

            is ImagesBrowseEvent.SearchButtonClicked -> {
                getImages()
            }

            is ImagesBrowseEvent.SearchPhraseChanged -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        searchString = event.value
                    )
                }
            }
            is ImagesBrowseEvent.TileClicked ->{
                _state.value = state.value.copy(seeTileId = event.id)
            }
        }
    }

    private fun getImages() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                images = imagesBrowseUseCases.getImages(state.value.searchString)
            )
        }
    }

    fun removeSeeImageDetailsValue(){
        _state.value = state.value.copy(seeTileId = null)
    }
}