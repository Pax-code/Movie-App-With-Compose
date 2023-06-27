package com.example.movieappwithcompose.presentation

sealed class Screen(val route: String){

    object MovieScreen: Screen("MovieScreen")
    object DetailsScreen: Screen("DetailsScreen")

}
