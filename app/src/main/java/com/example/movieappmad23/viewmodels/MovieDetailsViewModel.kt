package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieDetailsViewModel(private val movieRepository: MovieRepository, private val movieId: String) : ViewModel() {
    val movie: Flow<Movie?> = movieRepository.getMovieById(movieId)

    suspend fun toggleFavorite(movie: Movie) {
        movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
    }
}