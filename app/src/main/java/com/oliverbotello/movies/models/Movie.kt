package com.oliverbotello.movies.models

import com.google.gson.annotations.SerializedName
import com.oliverbotello.movies.utils.BASE_IMAGE_URL
import com.oliverbotello.movies.utils.BASE_MIN_IMAGE_URL
import com.oliverbotello.movies.utils.toStringFormat
import java.util.*


data class Movie(
    val id: Int = 0,
    val title: String = "",
    @SerializedName("release_date")
    val releaseDate: String = Date().toStringFormat("yyyy-MM-dd"),
    @SerializedName("vote_average")
    val voteAverage: Float = 0f,
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    val overview: String = "",
) {
    fun getPosterUrl(mini: Boolean = false): String =
        "${if (mini) BASE_MIN_IMAGE_URL else BASE_IMAGE_URL }${this.posterPath}"


    fun getBackdrop(mini: Boolean = false): String =
        "${if (mini) BASE_MIN_IMAGE_URL else BASE_IMAGE_URL }${this.backdropPath}"
}
