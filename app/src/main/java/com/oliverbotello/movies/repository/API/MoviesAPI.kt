package com.oliverbotello.movies.repository.API

import com.oliverbotello.movies.models.APIResult
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Serie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesAPI {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<APIResult<Movie>>

    @GET("tv/popular")
    fun getPopularTv(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<APIResult<Serie>>
}