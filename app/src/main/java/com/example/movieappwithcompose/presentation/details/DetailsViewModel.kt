package com.example.movieappwithcompose.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappwithcompose.domain.use_case.get_details.GetDetailsUseCase
import com.example.movieappwithcompose.util.Constants.IMDB_ID
import com.example.movieappwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(

    private val getDetailsUseCase: GetDetailsUseCase,
    private val stateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<DetailsState>(DetailsState())

    val state : State<DetailsState> = _state

   init {
       stateHandle.get<String>(IMDB_ID)?.let {
           getDetails(it)
       }

   }

    private fun getDetails(imdbID: String){
        getDetailsUseCase.execGetDetails(imdbID).onEach {
            when(it){
                is Resource.Success -> {

                    _state.value = DetailsState(movie = it.data)

                }

                is Resource.Error -> {

                    _state.value = DetailsState(error = it.message ?: "Error")


                }

                is Resource.Loading -> {

                    _state.value = DetailsState(isLoading = true)

                }

            }
        }.launchIn(viewModelScope)
    }
}