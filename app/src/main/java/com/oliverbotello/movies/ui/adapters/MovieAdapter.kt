package com.oliverbotello.movies.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oliverbotello.movies.models.Movie

class MovieAdapter(private val onClick: (Movie) -> Unit) :
    ListAdapter<Movie, MovieVH>(MovieDiffCallback) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieVH =
        if (viewType != 1)
            MovieVH.newInstance(viewGroup, onClick)
        else
            GoodMovieVH.newInstance(viewGroup, onClick)

    override fun onBindViewHolder(viewHolder: MovieVH, position: Int) {
        viewHolder.bind(this.getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return this.getItem(position).voteAverage.toInt().div(8)
    }
}
