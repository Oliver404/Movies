package com.oliverbotello.movies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Show
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import kotlinx.android.synthetic.main.card_movie_layout.view.*

class MovieVH(view: View, onClick: (Show) -> Unit) : ShowVH<Movie>(view, onClick) {

    override fun bind(show: Show) {
        this.currentShow = show
        this.itemView.txtVw_Title.text = show.getTitleShow()
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
