package com.oliverbotello.movies.models

import com.google.gson.annotations.SerializedName
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import java.util.*

class Movie(
    id: Int = 0,
    val title: String = "",
    voteAverage: Float = 0f,
    posterPath: String = "",
    backdropPath: String = "",
    overview: String = "",
    @SerializedName("release_date")
    val releaseDate: String = Date().toStringFormat("yyyy-MM-dd"),
) : Show(id, voteAverage, posterPath, backdropPath, overview) {
    override fun getTitleShow(): String = this.title

    override fun getDate(): String =
        if (this.releaseDate.isNullOrBlank()) ""
        else this.releaseDate.toDate().toStringFormat()
}