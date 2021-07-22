package com.oliverbotello.movies.interfaces

import com.oliverbotello.movies.models.Show

interface CallbackRepository {
    fun onSuccess(lstMovies: List<Show>)

    fun onFail(error: String)
}