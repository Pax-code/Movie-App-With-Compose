package com.example.movieappwithcompose.data.remote.dto

import com.example.movieappwithcompose.domain.model.Movie

data class MoviesDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDTO.toMovieList(): List<Movie>{

    return Search.map { search -> Movie(search.Poster ,search.Title, search.Type, search.Year, search.imdbID)  }
}