package com.oliverbotello.movies.models

data class MoviesResult(
    val page: Int = 0,
    val results: List<Movie> = listOf()
)