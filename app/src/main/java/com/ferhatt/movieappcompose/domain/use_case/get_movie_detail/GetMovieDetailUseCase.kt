package com.ferhatt.movieappcompose.domain.use_case.get_movie_detail

import com.ferhatt.movieappcompose.data.remote.dto.toMovieDetail
import com.ferhatt.movieappcompose.data.remote.dto.toMovieList
import com.ferhatt.movieappcompose.domain.model.Movie
import com.ferhatt.movieappcompose.domain.model.MovieDetail
import com.ferhatt.movieappcompose.domain.repository.MovieRepository
import com.ferhatt.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbId : String) : Flow<Resource<MovieDetail>> = flow {

        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e : IOError){
            emit(Resource.Error("No Internet Connection"))
        } catch (e : HttpException){
            emit(Resource.Error("No Internet Connection"))
        }
    }
}