package com.example.movieappmad23.data

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.utils.CustomConverters

@Database(
    entities = [Movie::class],
    //Wenn das Datenbankschema verändert wird MUSS die version aktualisiert werden sonst Error
    version = 1,
    exportSchema = false,
)

@TypeConverters(CustomConverters::class)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao

    //Instanzierung Singleton Object (statische Variable)
    companion object{
        @Volatile //heißt variable Instance soll nicht gechaced werden=>keine Instant soll überschrieben werden von 2 Threads
        private var Instance: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase{
            return Instance?: synchronized(this){

                Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }

        }

    }
}