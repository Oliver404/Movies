package com.oliverbotello.movies.models

import com.google.gson.annotations.SerializedName
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import java.util.*

class Serie(
    id: Int = 0,
    val name: String = "",
    voteAverage: Float = 0f,
    posterPath: String = "",
    backdropPath: String = "",
    overview: String = "",
    @SerializedName("first_air_date")
    val firstAirDate: String = Date().toStringFormat("yyyy-MM-dd"),
) : Show(id, voteAverage, posterPath, backdropPath, overview) {
    override fun getTitleShow(): String = this.name

    override fun getDate(): String =
        if (this.firstAirDate.isNullOrBlank()) ""
        else this.firstAirDate.toDate().toStringFormat()
}