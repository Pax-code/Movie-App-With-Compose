package com.example.movieappwithcompose.data.remote.dto

import com.example.movieappwithcompose.domain.model.Details

data class DetailsDTO(
    val Actors: String,
    val Awards: String,
    val BoxOffice: String,
    val Country: String,
    val DVD: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val Poster: String,
    val Production: String,
    val Rated: String,
    val Ratings: List<Rating>,
    val Released: String,
    val Response: String,
    val Runtime: String,
    val Title: String,
    val Type: String,
    val Website: String,
    val Writer: String,
    val Year: String,
    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String
)


fun DetailsDTO.toDetails(): Details{
    return Details(Actors, Country, Director, Genre, Language, Plot, Poster, Rated, Released, Title, Type, Writer, Year, imdbRating)
}