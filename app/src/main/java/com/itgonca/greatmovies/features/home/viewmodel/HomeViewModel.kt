package com.itgonca.greatmovies.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.greatmovies.domain.model.CategoryDto
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import com.itgonca.greatmovies.utils.StateUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    private val _listMovies = MutableLiveData<StateUi<List<CategoryDto>>>()
    val listMovies: LiveData<StateUi<List<CategoryDto>>> get() = _listMovies

    init {
        fetchtrendingMovies()
    }

    fun fetchtrendingMovies() {
        viewModelScope.launch {
            _listMovies.value = StateUi.Loading
            moviesRepository.getMoviesByGenre()
                .catch { exception ->
                    _listMovies.value = StateUi.Error(exception)
                }
                .collect {
                    _listMovies.value = StateUi.Success(it)
                }
        }
    }
}