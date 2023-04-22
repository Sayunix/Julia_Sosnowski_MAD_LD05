package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class MoviesListViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movies: Flow<List<Movie>> = movieRepository.getAllMovies()

    suspend fun deleteMovie(movie: Movie) {
        movieRepository.delete(movie)
    }

    suspend fun toggleFavorite(movie: Movie) {
        movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
    }
}