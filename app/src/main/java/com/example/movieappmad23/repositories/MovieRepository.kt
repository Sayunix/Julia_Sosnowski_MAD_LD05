package com.example.movieappmad23.repositories

import com.example.movieappmad23.data.MovieDao
import com.example.movieappmad23.models.Movie
import kotlinx.coroutines.flow.Flow



//Viewmodel nutzt Repo um mit Datenbank zu kommunizieren
class MovieRepository(private val movieDao: MovieDao) {
    suspend fun add(movie: Movie) = movieDao.insert(movie)

    suspend fun deleteMovie(movie: Movie) = movieDao.delete(movie)

    suspend fun updateMovie (movie: Movie) = movieDao.update(movie)

    suspend fun getById(id: String): Movie = movieDao.getMovie(id)

    fun getAllMovies(): Flow<List<Movie>> = movieDao.getAllMovies()
    fun getAllFavoriteMovies(): Flow<List<Movie>> = movieDao.getAllFavoriteMovies()

}
