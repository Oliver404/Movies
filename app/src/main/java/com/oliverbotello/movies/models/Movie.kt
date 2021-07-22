package com.oliverbotello.movies.models

import com.google.gson.annotations.SerializedName
import com.oliverbotello.movies.utils.BASE_IMAGE_URL
import com.oliverbotello.movies.utils.BASE_MIN_IMAGE_URL
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import java.util.*


class Movie(
    id: Int = 0,
    title: String = "",
    @SerializedName("release_date")
    val releaseDate: String = Date().toStringFormat("yyyy-MM-dd"),
    voteAverage: Float = 0f,
    posterPath: String = "",
    backdropPath: String = "",
    overview: String = "",
) : Show(id, title, voteAverage, posterPath, backdropPath, overview) {
    override fun getDate(): String =
        if (this.releaseDate.isNullOrBlank()) ""
        else this.releaseDate.toDate().toStringFormat()
}
