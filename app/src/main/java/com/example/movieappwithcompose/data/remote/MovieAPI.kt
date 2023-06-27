package com.example.movieappwithcompose.data.remote

import com.example.movieappwithcompose.data.remote.dto.DetailsDTO
import com.example.movieappwithcompose.data.remote.dto.MoviesDTO
import com.example.movieappwithcompose.util.Constants.api_key
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(

        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = api_key


    ) : MoviesDTO


    @GET(".")
    suspend fun getDetails(

        @Query("i") imdbID: String,
        @Query("apikey") apiKey: String = api_key

    ) : DetailsDTO


}