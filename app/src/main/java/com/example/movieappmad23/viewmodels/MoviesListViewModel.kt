package com.example.movieappmad23.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

/*Hier verwenden wir das MovieRepository, um auf die CRUD-Operationen zuzugreifen.
movies ist ein Flow<List<Movie>>, der alle Filme aus Ihrer Datenbank abruft.
Die deleteMovie und toggleFavorite Funktionen sind asynchrone Aktionen,
die innerhalb von viewModelScope.launch Blöcken aufgerufen werden, um sicherzustellen,
dass sie auf dem Hintergrundthread ausgeführt werden und die App-UI nicht blockieren.*/

class MoviesListViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movies: Flow<List<Movie>> = movieRepository.getAllMovies()

    suspend fun deleteMovie(movie: Movie) {
        movieRepository.delete(movie)
    }

    suspend fun toggleFavorite(movie: Movie) {
        movieRepository.update(movie.copy(isFavorite = !movie.isFavorite))
    }

    suspend fun updateFavoriteMovies(movie: Movie) {
        val updatedMovie = movie.copy(isFavorite = !movie.isFavorite)
        movieRepository.update(updatedMovie)
    }
}
