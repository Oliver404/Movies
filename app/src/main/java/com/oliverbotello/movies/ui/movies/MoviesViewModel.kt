package com.oliverbotello.movies.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oliverbotello.movies.interfaces.CallbackRepository
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.repository.MovieRepository

class MoviesViewModel : ViewModel(), CallbackRepository {
    val bussy: MutableLiveData<Boolean> = MutableLiveData(false);
    val lstMovies: MutableLiveData<MutableList<Movie>> = MutableLiveData(mutableListOf())
    var movieRepository: MovieRepository = MovieRepository()

    fun initMovies() {
        this.bussy.value = true
        movieRepository.getPopularMovies(this)
    }

    override fun onSuccess(lstMovies: List<Movie>) {
        this.lstMovies.value = lstMovies.toMutableList()
        this.bussy.value = false
    }

    override fun onFail(error: String) {
        this.bussy.value = false
    }
}