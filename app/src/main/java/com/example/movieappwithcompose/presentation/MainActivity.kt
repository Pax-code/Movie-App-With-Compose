package com.example.movieappwithcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappwithcompose.presentation.details.views.DetailsScreen
import com.example.movieappwithcompose.presentation.movies.views.MovieScreen
import com.example.movieappwithcompose.presentation.ui.MovieAppWithComposeTheme
import com.example.movieappwithcompose.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieAppWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination =  Screen.MovieScreen.route){

                        composable(route = Screen.MovieScreen.route ){
                            MovieScreen(navController = navController)
                        }

                        composable(route = Screen.DetailsScreen.route + "/{${IMDB_ID}}"){
                            DetailsScreen()
                        }

                    }

                }
            }
        }
    }
}
