package com.oliverbotello.movies.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oliverbotello.movies.models.APIResult
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Serie
import com.oliverbotello.movies.models.Show
import com.oliverbotello.movies.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesViewModel : ViewModel(), Callback<APIResult<Movie>> {
    val bussy: MutableLiveData<Boolean> = MutableLiveData(false);
    val lstMovies: MutableLiveData<MutableList<Show>> = MutableLiveData(mutableListOf())
    var movieRepository: MovieRepository = MovieRepository()

    fun initMovies() {
        this.bussy.value = true

        movieRepository.getPopularMovies(this as Callback<APIResult<Movie>>)
        movieRepository.getPopularSeries(this as Callback<APIResult<Serie>>)
    }

    override fun onResponse(call: Call<APIResult<Movie>>, response: Response<APIResult<Movie>>) {
        if (response.isSuccessful) {
            if (response.body() !== null) {
                var lstShows = mutableListOf<Show>()

                lstShows.addAll(this.lstMovies.value?.toList()?: listOf())
                lstShows.addAll(response.body()!!.results.toMutableList())

                this.lstMovies.value = lstShows
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

    override fun onFailure(call: Call<APIResult<Movie>>, t: Throwable) {
        // Error
        this.bussy.value = false
    }
}