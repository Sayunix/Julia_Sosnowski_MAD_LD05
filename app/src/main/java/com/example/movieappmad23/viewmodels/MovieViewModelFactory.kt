import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad23.repositories.MovieRepository
import com.example.movieappmad23.viewmodels.FavoriteMoviesViewModel
import com.example.movieappmad23.viewmodels.MovieDetailsViewModel
import com.example.movieappmad23.viewmodels.MoviesListViewModel

class MoviesListViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesListViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class FavoriteMoviesViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteMoviesViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class MovieDetailsViewModelFactory(private val movieRepository: MovieRepository, private val movieId: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailsViewModel(movieRepository, movieId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
