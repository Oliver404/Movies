package com.oliverbotello.movies.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.oliverbotello.movies.models.Show

object MovieDiffCallback : DiffUtil.ItemCallback<Show>() {
    override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean =
        oldItem.id == newItem.id
}
