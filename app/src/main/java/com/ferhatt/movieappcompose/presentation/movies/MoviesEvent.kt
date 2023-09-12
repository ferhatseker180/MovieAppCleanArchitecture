package com.ferhatt.movieappcompose.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()
}