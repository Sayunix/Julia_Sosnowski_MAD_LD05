package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeScreenViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _movieListState = MutableStateFlow(listOf<Movie>())
    val movieListState: StateFlow<List<Movie>> = _movieListState.asStateFlow()

    init {
        viewModelScope.launch {
            movieRepository.getAllMovies().collect { movieList ->
                _movieListState.value = movieList
            }
        }
    }

    suspend fun toggleFavoriteMovies(movieID: String) {
        val movie: Movie = movieRepository.getById(movieID)
        movie.isFavorite = !movie.isFavorite
        movieRepository.updateMovie(movie)
    }
}

