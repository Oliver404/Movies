package com.oliverbotello.movies.repository

import com.oliverbotello.movies.data.MoviesData
import com.oliverbotello.movies.interfaces.CallbackRepository
import com.oliverbotello.movies.models.Movie

class MovieRepository {
    fun getPopularMovies(callback: CallbackRepository) {
        val lstMovies: List<Movie> = MovieData.getPopularMovies()
        callback.onSuccess(lstMovies);
    }

    companion object {
        private val MovieData = MoviesData;
    }
}