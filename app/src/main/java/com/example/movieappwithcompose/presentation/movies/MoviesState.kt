package com.example.movieappwithcompose.presentation.movies

import com.example.movieappwithcompose.data.remote.dto.Search
import com.example.movieappwithcompose.domain.model.Movie

data class MoviesState(


    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "interstellar"

    )
