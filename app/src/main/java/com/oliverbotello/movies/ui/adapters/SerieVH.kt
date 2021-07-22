package com.oliverbotello.movies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Serie
import com.oliverbotello.movies.models.Show
import kotlinx.android.synthetic.main.card_movie_layout.view.*

class SerieVH(view: View, onClick: (Show) -> Unit) : ShowVH<Serie>(view, onClick){
    override fun bind(show: Serie) {
        this.currentShow = show
        this.itemView.txtVw_Title.text = show.title
        this.itemView.txtVw_Date.text = show.getDate()
        this.itemView.txtVw_Range.text = show.voteAverage.toString()

        Glide
            .with(this.itemView.context)
            .load(show.getBackdrop())
            .placeholder(R.drawable.ic_movie)
            .into(this.itemView.imgVw_Movie)
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup, onClick: (Show) -> Unit): MovieVH =
            MovieVH(
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.card_movie_layout, viewGroup, false),
                onClick
            )
    }
}
