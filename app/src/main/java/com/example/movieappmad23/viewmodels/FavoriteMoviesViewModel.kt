package com.example.movieappmad23.viewmodels

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class FavoriteMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val favoriteMovies: Flow<List<Movie>> = movieRepository.getAllFavoriteMovies()

    suspend fun deleteMovie(movie: Movie) {
        movieRepository.delete(movie)
    }

    suspend fun toggleFavorite(movie: Movie) {
        movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
    }

}