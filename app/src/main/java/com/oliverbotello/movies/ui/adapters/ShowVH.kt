package com.oliverbotello.movies.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oliverbotello.movies.models.Show

abstract class ShowVH<T : Show>(view: View, val onClick: (Show) -> Unit)
    : RecyclerView.ViewHolder(view) {
    protected var currentShow: Show? = null

    init {
        this.itemView.setOnClickListener {
            this.currentShow?.let {
                this.onClick(it)
            }
        }
    }

    abstract fun bind(show: Show)
}