package com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.imagesearchapp.feature_images_browse.domain.models.BasicImageInfo
import com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.ImagesBrowseViewModel
import com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.components.TileItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImagesBrowseScreen(
    navController: NavController,
    viewModel: ImagesBrowseViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    Scaffold {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Divide tags with space (tag1 tag2 tag3...)")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                val tagsValue = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = tagsValue.value,
                    onValueChange = { tagsValue.value = it },
                    modifier = Modifier.weight(5f),
                    label = { Text("Enter tags") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                ExtendedFloatingActionButton(
                    modifier = Modifier.weight(3f),
                    onClick = { viewModel.onEvent(ImagesBrowseEvent.Search("tags")) },//Todo add real tags
                    text = { Text(text = "Search") },
                    icon = { Icon(imageVector = Icons.Filled.Search, contentDescription = null) },
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.width(8.dp))


            }

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                val tiles = state.images

                items(tiles) { tile ->
                    TileItem(tile)
                }
            }
        }
    }
}

