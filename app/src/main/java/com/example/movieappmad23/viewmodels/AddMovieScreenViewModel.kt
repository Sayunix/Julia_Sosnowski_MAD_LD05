package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository


class AddMovieScreenViewModel(private val movieRepository: MovieRepository): ViewModel() {
    suspend fun insert(movie: Movie) {
        movieRepository.add(movie)
    }

    //  fun updateFavoriteMovies(movie: Movie) = _movieListState.value.find { it.id == movie.id }?.let { movie ->
    //      movie.isFavorite = !movie.isFavorite
    //  }
}