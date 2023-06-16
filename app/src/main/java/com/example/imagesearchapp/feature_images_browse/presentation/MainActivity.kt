package com.example.imagesearchapp.feature_images_browse.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagesearchapp.feature_images_browse.presentation.screens.image_details_screen.ImageDetailsScreen
import com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.ImagesBrowseScreen
import com.example.imagesearchapp.ui.theme.ImageSearchAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSearchAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "browseScreen") {
                        composable("browseScreen") { ImagesBrowseScreen(navController = navController) }
                        composable("imageDetailsScreen/{imageId}") {
                            val imageId = it.arguments?.getString("imageId")
                            ImageDetailsScreen(navController = navController, imageId!!)
                        }
                    }
                }
            }
        }
    }
}