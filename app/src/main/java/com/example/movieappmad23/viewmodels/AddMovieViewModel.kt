package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.movieappmad23.repositories.MovieRepository
import com.example.movieappmad23.screens.AddMovieUIEvent
import com.example.movieappmad23.screens.AddMovieUiState
import com.example.movieappmad23.screens.hasError
import com.example.movieappmad23.screens.toMovie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddMovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movieUiState = MutableStateFlow(AddMovieUiState())

    val movieUiState: StateFlow<AddMovieUiState>
        get() = _movieUiState

    fun updateUIState(uiState: AddMovieUiState, event: AddMovieUIEvent) {
        _movieUiState.value = when (event) {
            AddMovieUIEvent.TitleChanged -> uiState.copy(
                title = uiState.title,
                titleErr = uiState.titleErr
            )
            AddMovieUIEvent.YearChanged -> uiState.copy(
                year = uiState.year,
                yearErr = uiState.yearErr
            )
            AddMovieUIEvent.GenresChanged -> uiState.copy(
                genre = uiState.genre,
                genreErr = uiState.genreErr
            )
            AddMovieUIEvent.DirectorChanged -> uiState.copy(
                director = uiState.director,
                directorErr = uiState.directorErr
            )
            AddMovieUIEvent.ActorsChanged -> uiState.copy(
                actors = uiState.actors,
                actorsErr = uiState.actorsErr
            )
            AddMovieUIEvent.PlotChanged -> uiState.copy(
                plot = uiState.plot
            )
            AddMovieUIEvent.RatingChanged -> uiState.copy(
                rating = uiState.rating,
                ratingErr = uiState.ratingErr
            )
            else -> uiState
        }
        updateActionButtonState()
    }

    private fun updateActionButtonState() {
        _movieUiState.value = _movieUiState.value.copy(
            actionEnabled = !_movieUiState.value.hasError()
        )
    }

    fun saveMovie() {
        viewModelScope.launch {
            val movie = _movieUiState.value.toMovie()
            repository.insert(movie)
        }
    }
}