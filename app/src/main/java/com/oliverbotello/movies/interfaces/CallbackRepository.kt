package com.oliverbotello.movies.interfaces

import com.oliverbotello.movies.models.Movie

interface CallbackRepository {
    fun onSuccess(lstMovies: List<Movie>)

    fun onFail(error: String)
}