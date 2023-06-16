package com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen.components.DisplayLargeImageFromUrl
import com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen.components.ImageStats
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageDetailsScreen(
    navController: NavController,
    imageId: String,
    viewModel: ImageDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.loadImageDetails(imageId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Image Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) {
        state.imageDetails?.let {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                DisplayLargeImageFromUrl(
                    imageUrl = state.imageDetails.largeImageURL,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ImageStats(
                        value = state.imageDetails.likes,
                        name = "likes",
                        imageVector = Icons.Default.Favorite
                    )
                    ImageStats(
                        value = state.imageDetails.comments,
                        name = "comments",
                        imageVector = Icons.Default.List
                    )
                    ImageStats(
                        value = state.imageDetails.downloads,
                        name = "Downloads",
                        imageVector = Icons.Default.ArrowDropDown
                    )
                }
                Row {
                    Text(text = "user: ")
                    Text(text = state.imageDetails.user)
                }
                Text(text = state.imageDetails.tags)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }


}