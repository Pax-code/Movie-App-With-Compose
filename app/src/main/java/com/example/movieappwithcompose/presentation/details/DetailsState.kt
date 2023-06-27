package com.example.movieappwithcompose.presentation.details

import com.example.movieappwithcompose.domain.model.Details


data class DetailsState (


    val isLoading: Boolean = false,
    val movie: Details? = null,
    val error: String = ""


)
