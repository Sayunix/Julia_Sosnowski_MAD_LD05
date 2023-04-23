package com.example.movieappmad23.utils

import android.content.Context
import com.example.movieappmad23.data.MovieDatabase
import com.example.movieappmad23.repositories.MovieRepository
import com.example.movieappmad23.viewmodels.AddMovieScreenViewModelFactory
import com.example.movieappmad23.viewmodels.DetailScreenViewModelFactory
import com.example.movieappmad23.viewmodels.FavoriteScreenViewModelFactory
import com.example.movieappmad23.viewmodels.HomeScreenViewModelFactory

object InjectorUtils {
    private fun getMovieRepository(context: Context): MovieRepository {
        return MovieRepository(MovieDatabase.getDatabase(context).movieDao())
    }

    fun provideHomeScreenViewModelFactory(context: Context): HomeScreenViewModelFactory {
        val repository = getMovieRepository(context)
        return HomeScreenViewModelFactory(repository)
    }

    fun provideFavoriteScreenViewModelFactory(context: Context): FavoriteScreenViewModelFactory {
        val repository = getMovieRepository(context)
        return FavoriteScreenViewModelFactory(repository)
    }

    fun provideDetailScreenViewModelFactory(context: Context): DetailScreenViewModelFactory {
        val repository = getMovieRepository(context)
        return DetailScreenViewModelFactory(repository)
    }

    fun provideAddMovieViewModelFactory(context: Context): AddMovieScreenViewModelFactory {
        val repository = getMovieRepository(context)
        return AddMovieScreenViewModelFactory(repository)
    }
}