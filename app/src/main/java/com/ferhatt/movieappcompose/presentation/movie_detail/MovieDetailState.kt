package com.ferhatt.movieappcompose.presentation.movie_detail

import com.ferhatt.movieappcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movieDetail: MovieDetail ?= null,
    val error : String = ""

)