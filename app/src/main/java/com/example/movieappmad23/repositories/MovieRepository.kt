package com.example.movieappmad23.repositories

import com.example.movieappmad23.data.MovieDao
import com.example.movieappmad23.data.MovieDatabase
import com.example.movieappmad23.data.MovieDatabase.Companion.getDatabase
import com.example.movieappmad23.models.Movie
import kotlinx.coroutines.flow.Flow



//Viewmodel nutzt Repo um mit Datenbank zu kommunizieren
class MovieRepository(private val movieDao: MovieDao) {

    private lateinit var database: MovieDatabase

    suspend fun insert(movie: Movie) = database.movieDao().insert(movie)

    suspend fun delete(movie: Movie) = database.movieDao().delete(movie)

    suspend fun update (movie: Movie) = database.movieDao().update(movie)

    fun getAllMovies(): Flow<List<Movie>> = database.movieDao().getAllMovies()
    fun getAllFavoriteMovies(): Flow<List<Movie>> = database.movieDao().getAllFavoriteMovies()
    fun getMovieById(movieId: String): Flow<Movie?> = database.movieDao().getMovieById(movieId)
}
