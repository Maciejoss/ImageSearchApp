package com.example.imagesearchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagesearchapp.feature_images_browse.presentation.screens.images_browse_screen.components.ImagesBrowseScreen
import com.example.imagesearchapp.ui.theme.ImageSearchAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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

                    NavHost(navController = navController, startDestination = "profile") {
                        composable("profile") { ImagesBrowseScreen(navController = navController) }
                        /*...*/
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


interface WeatherApi {
    suspend fun getTemperature(city: String): Int
}

class WeatherApii:WeatherApi{
    override suspend fun getTemperature(city: String): Int {
        return 1
    }

}

class WeatherService @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getTemperature(city: String): Int {
        return api.getTemperature(city)
    }
}

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherService: WeatherService
) : ViewModel() {

    var bucharestTemperature = 1
        private set

    init {

    }
}

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val temperature = viewModel.bucharestTemperature

    Text(
        text = "Hello dziala!",
    )
}