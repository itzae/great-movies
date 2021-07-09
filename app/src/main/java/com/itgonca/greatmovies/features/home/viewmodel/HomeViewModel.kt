package com.itgonca.greatmovies.features.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {


    fun fetchtrendingMovies() {
        viewModelScope.launch {
            moviesRepository.getTrendingMovies().collect {
                Log.d("TAG", "fetchtrendingMovies: $it")
            }
        }
    }
}