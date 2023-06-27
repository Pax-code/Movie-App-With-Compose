package com.example.movieappwithcompose.domain.use_case.get_details

import com.example.movieappwithcompose.data.remote.dto.toDetails
import com.example.movieappwithcompose.domain.model.Details
import com.example.movieappwithcompose.domain.repository.MovieRepo
import com.example.movieappwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val repo: MovieRepo) {

    fun execGetDetails(imdbID: String): Flow<Resource<Details>> = flow{

        try {

            emit(Resource.Loading())
            val movieDetails = repo.getDetails(imdbID)
            emit(Resource.Success(movieDetails.toDetails()))


        }catch (e: IOError){
            emit(Resource.Error(message = "No Internet Connection"))
        }

    }
}