package com.ferhatt.movieappcompose.domain.repository

import com.ferhatt.movieappcompose.data.remote.dto.MovieDetailDto
import com.ferhatt.movieappcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto

}