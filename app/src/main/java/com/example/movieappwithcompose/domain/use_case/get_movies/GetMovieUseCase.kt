package com.example.movieappwithcompose.domain.use_case.get_movies

import com.example.movieappwithcompose.data.remote.dto.toMovieList
import com.example.movieappwithcompose.domain.model.Movie
import com.example.movieappwithcompose.domain.repository.MovieRepo
import com.example.movieappwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repo: MovieRepo) {

    fun execGetMovies(search: String): Flow<Resource<List<Movie>>> = flow{

       try {

           emit(Resource.Loading())
           val movieList = repo.getMovies(search)
           if (movieList.Response == "True") {
               emit(Resource.Success(movieList.toMovieList()))
           } else{
               emit(Resource.Error(message = "Movie cannot found"))
           }

       }catch (e: IOError){
           emit(Resource.Error(message = "No Internet Connection"))
       }

    }

}