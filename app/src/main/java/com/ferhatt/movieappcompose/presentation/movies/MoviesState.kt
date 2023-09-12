package com.ferhatt.movieappcompose.presentation.movies

import com.ferhatt.movieappcompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = ""

) {
}