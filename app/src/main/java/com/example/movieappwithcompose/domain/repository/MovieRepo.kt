package com.example.movieappwithcompose.domain.repository


import com.example.movieappwithcompose.data.remote.dto.DetailsDTO
import com.example.movieappwithcompose.data.remote.dto.MoviesDTO

interface MovieRepo {

    suspend fun getMovies(search: String): MoviesDTO

    suspend fun getDetails(imdbID: String): DetailsDTO

}