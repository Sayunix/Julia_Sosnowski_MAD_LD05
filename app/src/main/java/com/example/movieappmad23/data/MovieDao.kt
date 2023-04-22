package com.example.movieappmad23.data

import androidx.room.*
import com.example.movieappmad23.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    // CRUD = Create, Read, Update, Delete
    @Insert
    suspend fun insert(movie: Movie)

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    //Flow ist eine Bibliothek in Kotlin, die es ermöglicht, asynchrone Datenströme (Streams) von
    //Daten zu verarbeiten und zu transformieren. Mit Flow können Sie auf Ereignisse reagieren,
    //die asynchron und unvorhersehbar auftreten können, wie z.B. Benutzerinteraktionen oder
    //Netzwerkantworten.
    @Query("SELECT * from movie")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("Select * from movie where isFavorite = 1")
    fun getAllFavouriteMovies(): Flow<List<Movie>>

    @Query("Select * from movie where id=:movieId")
    fun getMovieById(movieId: String): Flow<Movie?>

    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getAllFavoriteMovies(): Flow<List<Movie>>
    //@Query("DELETE from Movie")
    //fun deleteAll()

}