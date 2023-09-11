package com.ferhatt.movieappcompose.domain.use_case.get_movies

import android.net.http.HttpException
import com.ferhatt.movieappcompose.data.remote.dto.toMovieList
import com.ferhatt.movieappcompose.domain.model.Movie
import com.ferhatt.movieappcompose.domain.repository.MovieRepository
import com.ferhatt.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {

        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error("Movie Not Found!"))
            }
        }catch (e : IOError){
            emit(Resource.Error("No Internet Connection"))
        } catch (e : retrofit2.HttpException){
            emit(Resource.Error("No Internet Connection"))
        }
    }
}