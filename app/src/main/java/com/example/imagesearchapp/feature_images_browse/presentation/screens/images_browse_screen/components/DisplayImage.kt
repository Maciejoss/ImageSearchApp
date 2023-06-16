package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

@Composable
fun DisplayImageFromUrl(imageUrl: String) {

    AsyncImage(
        model = imageUrl,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
    )
}