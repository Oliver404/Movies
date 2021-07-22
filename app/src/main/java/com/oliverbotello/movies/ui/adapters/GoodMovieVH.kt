package com.oliverbotello.movies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import kotlinx.android.synthetic.main.card_movie_layout.view.*

class GoodMovieVH(view: View, onClick: (Movie) -> Unit) : MovieVH(view, onClick) {
    companion object {
        fun newInstance(viewGroup: ViewGroup, onClick: (Movie) -> Unit): GoodMovieVH =
            GoodMovieVH(
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.card_good_movie_layout, viewGroup, false),
                onClick
            )
    }
}
