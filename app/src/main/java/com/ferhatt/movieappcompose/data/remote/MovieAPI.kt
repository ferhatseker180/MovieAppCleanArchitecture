package com.ferhatt.movieappcompose.data.remote

import com.ferhatt.movieappcompose.data.remote.dto.MovieDetailDto
import com.ferhatt.movieappcompose.data.remote.dto.MoviesDto
import com.ferhatt.movieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    // https://www.omdbapi.com/?apikey=18119dc9&s=batman
    // https://www.omdbapi.com/?i=tt3896198&apikey=18119dc9
    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto

}