package com.oliverbotello.movies.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Show

object ShowDiffCallback : DiffUtil.ItemCallback<Show>() {
    override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean =
        oldItem.id == newItem.id
}
