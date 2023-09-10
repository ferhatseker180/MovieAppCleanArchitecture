package com.ferhatt.movieappcompose.data.repository

import com.ferhatt.movieappcompose.data.remote.MovieAPI
import com.ferhatt.movieappcompose.data.remote.dto.MovieDetailDto
import com.ferhatt.movieappcompose.data.remote.dto.MoviesDto
import com.ferhatt.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplemantation @Inject constructor(private val api : MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }

}