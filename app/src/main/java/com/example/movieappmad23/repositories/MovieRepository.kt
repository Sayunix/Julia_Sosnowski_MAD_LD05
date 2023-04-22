package com.example.movieappmad23.repositories

import com.example.movieappmad23.data.MovieDao
import com.example.movieappmad23.models.Movie
import kotlinx.coroutines.flow.Flow


//Viewmodel nutzt Repo um mit Datenbank zu kommunizieren
class MovieRepository(private val movieDao: MovieDao) {

    suspend fun insert(movie: Movie) = movieDao.insert(movie)

    suspend fun delete(movie: Movie) = movieDao.delete(movie)

    suspend fun update (movie: Movie) = movieDao.update(movie)

    fun getAllMovies(): Flow<List<Movie>> = movieDao.getAllMovies()
    fun getAllFavoriteMovies(): Flow<List<Movie>> = movieDao.getAllFavoriteMovies()
    fun getMovieById(movieId: String): Flow<Movie?> = movieDao.getMovieById(movieId)
}
