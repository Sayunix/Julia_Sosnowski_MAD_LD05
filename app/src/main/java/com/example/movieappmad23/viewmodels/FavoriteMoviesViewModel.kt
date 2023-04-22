package com.example.movieappmad23.viewmodels

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoriteMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val favoriteMovies: Flow<List<Movie>> = movieRepository.getAllFavoriteMovies()

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            movieRepository.delete(movie)
        }
    }

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
        }
    }
}
