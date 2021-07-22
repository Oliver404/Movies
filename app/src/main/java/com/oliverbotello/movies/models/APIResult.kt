package com.oliverbotello.movies.models

data class APIResult<T : Show>(
    val page: Int = 0,
    val results: List<T>,
    val totalPages: Int,
    val totalResults: Int,
)