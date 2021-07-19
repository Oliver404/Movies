package com.oliverbotello.movies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.utils.toStringFormat
import kotlinx.android.synthetic.main.card_movie_layout.view.*

class MovieVH(view: View, val onClick: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {
    private var currentMovie: Movie? = null

    init {
        this.itemView.setOnClickListener {
            this.currentMovie?.let {
                this.onClick(it)
            }
        }
    }

    fun bind(movie: Movie) {
        this.currentMovie = movie
        this.itemView.txtVw_Title.text = movie.title
        this.itemView.txtVw_Date.text = movie.releaseDate.toStringFormat()
        this.itemView.txtVw_Range.text = movie.voteAverage.toString()
        val idImage = this.itemView.context.resources.getIdentifier(
            movie.backdropPath.replace(".jpg", ""),
            "drawable",
            this.itemView.context.packageName
        )

        Glide
            .with(this.itemView.context)
            .load(this.itemView.context.getDrawable(idImage))
            .placeholder(R.drawable.ic_movie)
            .into(this.itemView.imgVw_Movie)
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup, onClick: (Movie) -> Unit): MovieVH =
            MovieVH(
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.card_movie_layout, viewGroup, false),
                onClick
            )
    }
}
