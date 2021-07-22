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


class MoviesViewModel : ViewModel(), Callback<APIResult<*>> {
    val bussy: MutableLiveData<Boolean> = MutableLiveData(false);
    val lstShows: MutableLiveData<MutableList<Show>> = MutableLiveData(mutableListOf())
    private var movieRepository: MovieRepository = MovieRepository()
    private var nResponse: Int = 0

    fun initMovies() {
        this.bussy.value = true

        movieRepository.getPopularMovies(this as Callback<APIResult<Movie>>)
        movieRepository.getPopularTv(this as Callback<APIResult<Serie>>)
    }

    override fun onResponse(call: Call<APIResult<*>>, response: Response<APIResult<*>>) {
        if (response.isSuccessful) {
            if (response.body() !== null) {
                var lstShows = this.lstShows.value;

                if (lstShows === null) {
                    lstShows = response.body()!!.results.toMutableList()
                }
                else {
                    lstShows.addAll(response.body()!!.results)
                }

                this.lstShows.value = lstShows
            }
            else {
                // Erorr
            }
        }
        else {
            // Error
        }

        if (this.nResponse > 0)
            this.bussy.value = false

        this.nResponse++
    }

    override fun onFailure(call: Call<APIResult<*>>, t: Throwable) {
        // Error
        this.bussy.value = false
    }
}