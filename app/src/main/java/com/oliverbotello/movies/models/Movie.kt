package com.oliverbotello.movies.models

import java.util.*


data class Movie(
    val id: Int = 0,
    val title: String = "",
    val releaseDate: Date = Date(),
    val voteAverage: Float = 0f,
    val posterPath: String = "",
    val backdropPath: String = "",
    val description: String = "",
)