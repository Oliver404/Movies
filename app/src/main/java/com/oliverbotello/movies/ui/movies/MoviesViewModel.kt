package com.oliverbotello.movies.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oliverbotello.movies.models.APIResult
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesViewModel : ViewModel(), Callback<APIResult> {
    val bussy: MutableLiveData<Boolean> = MutableLiveData(false);
    val lstMovies: MutableLiveData<MutableList<Movie>> = MutableLiveData(mutableListOf())
    var movieRepository: MovieRepository = MovieRepository()

    fun initMovies() {
        this.bussy.value = true
        movieRepository.getPopularMovies(this)
    }

    override fun onResponse(call: Call<APIResult>, response: Response<APIResult>) {
        if (response.isSuccessful) {
            if (response.body() !== null) {
                this.lstMovies.value = response.body()!!.results.toMutableList()
            }
            else {
                // Erorr
            }
        }
        else {
            // Error
        }

        this.bussy.value = false
    }

    override fun onFailure(call: Call<APIResult>, t: Throwable) {
        // Error
        this.bussy.value = false
    }
}