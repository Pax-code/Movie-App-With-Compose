package com.example.movieappwithcompose.data.repository

import com.example.movieappwithcompose.data.remote.MovieAPI
import com.example.movieappwithcompose.data.remote.dto.DetailsDTO
import com.example.movieappwithcompose.data.remote.dto.MoviesDTO
import com.example.movieappwithcompose.domain.repository.MovieRepo
import javax.inject.Inject

class MovieRepoImpl  @Inject constructor(private val api: MovieAPI): MovieRepo {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(searchString = search)
    }

    override suspend fun getDetails(imdbID: String): DetailsDTO {
        return api.getDetails(imdbID = imdbID)
    }
}