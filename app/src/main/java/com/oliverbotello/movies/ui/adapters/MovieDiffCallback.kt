package com.oliverbotello.movies.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.oliverbotello.movies.models.Movie

object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id
}
