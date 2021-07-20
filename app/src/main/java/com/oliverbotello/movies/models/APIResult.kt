package com.oliverbotello.movies.models

data class APIResult(
    val page: Int = 0,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int,
)