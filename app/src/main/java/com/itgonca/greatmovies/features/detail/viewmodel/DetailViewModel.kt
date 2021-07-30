package com.itgonca.greatmovies.features.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itgonca.greatmovies.domain.model.DetailDto
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import com.itgonca.greatmovies.utils.StateUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    private val _detailMovieInfo = MutableLiveData<StateUi<DetailDto>>()
    val detailMovieInfo: LiveData<StateUi<DetailDto>> get() = _detailMovieInfo

    fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _detailMovieInfo.value = StateUi.Loading
            moviesRepository.getMovieDetail(movieId).catch { exception ->
                _detailMovieInfo.value = StateUi.Error(exception)
            }.collect {
                _detailMovieInfo.value = StateUi.Success(it)
            }
        }
    }
}