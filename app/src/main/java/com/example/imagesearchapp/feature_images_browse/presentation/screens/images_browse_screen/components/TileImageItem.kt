package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo

@Composable
fun TileItem(tileInfo: BasicImageInfo) {
    val customCardColors = CardDefaults.cardColors(
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.surface,
        disabledContainerColor = MaterialTheme.colorScheme.onSurface,
    )
    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8. dp,
        pressedElevation = 2. dp,
        focusedElevation = 4. dp
    )

    Spacer(modifier = Modifier.height(30.dp))
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = customCardColors,
        elevation = customCardElevation
    ) {
        Row(

            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            DisplayImageFromUrl(imageUrl = tileInfo.largeImageURL)

            Spacer(modifier = Modifier.width(8.dp))

            Column(
            ) {
                Row(
                ) {
                    Text(
                        text = "user:",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )

                    Text(
                        text = tileInfo.user,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }
                Row() {
                    Text(
                        text = "tags:",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                    Text(
                        text = tileInfo.tags,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }


            }

        }
    }


}