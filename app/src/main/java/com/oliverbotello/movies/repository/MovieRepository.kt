package com.oliverbotello.movies.repository

import com.oliverbotello.movies.models.APIResult
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.repository.API.MoviesAPI
import com.oliverbotello.movies.utils.API_KEY
import com.oliverbotello.movies.utils.API_URL
import com.oliverbotello.movies.utils.DEFAULT_LANGUAGE
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieRepository {

    init {
        if (API_CONNECTION === null) {
            val retrofit = Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL).build()

            API_CONNECTION = retrofit.create(MoviesAPI::class.java)
        }
    }

    fun getPopularMovies(callback: Callback<APIResult>) {
        API_CONNECTION?.let {
            it.getPopularMovies(API_KEY, DEFAULT_LANGUAGE).enqueue(callback)
        }
    }

    companion object {
        //private val MovieData = MoviesData;
        private var API_CONNECTION: MoviesAPI? = null
    }
}