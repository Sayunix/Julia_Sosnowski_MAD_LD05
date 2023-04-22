package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movieRepository: MovieRepository, private val movieId: String) : ViewModel() {
    val movie: Flow<Movie?> = movieRepository.getMovieById(movieId)

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
        }
    }
}