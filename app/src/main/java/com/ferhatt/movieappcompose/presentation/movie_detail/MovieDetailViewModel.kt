package com.ferhatt.movieappcompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferhatt.movieappcompose.domain.use_case.get_movie_detail.GetMovieDetailUseCase
import com.ferhatt.movieappcompose.util.Constants.IMDB_ID
import com.ferhatt.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }


    private fun getMovieDetail(imdbId : String){
        getMovieDetailUseCase.executeGetMovieDetail(imdbId = imdbId).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = MovieDetailState(movieDetail = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)

    }
        
}