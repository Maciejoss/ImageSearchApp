package com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen.components


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DisplayLargeImageFromUrl(imageUrl: String, modifier: Modifier) {

    AsyncImage(
        model = imageUrl,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(400.dp)
    )
}