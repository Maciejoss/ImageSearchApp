package com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ImageStats(
    value: Int,
    name: String,
    imageVector: ImageVector
) {
    Column() {
        Text(text = name)
        Row() {
           Text(text = value.toString())
            Icon(imageVector = imageVector, contentDescription = "")
        }
    }

}