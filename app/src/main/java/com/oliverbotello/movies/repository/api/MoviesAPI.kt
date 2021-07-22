package com.oliverbotello.movies.repository.api

import com.oliverbotello.movies.models.MoviesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesAPI {
    @GET("popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<MoviesResult>
}