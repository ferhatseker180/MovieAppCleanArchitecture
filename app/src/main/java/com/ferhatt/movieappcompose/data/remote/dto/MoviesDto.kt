package com.ferhatt.movieappcompose.data.remote.dto

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)