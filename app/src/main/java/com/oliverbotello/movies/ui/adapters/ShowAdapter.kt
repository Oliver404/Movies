package com.oliverbotello.movies.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Show

class ShowAdapter(private val onClick: (Show) -> Unit) :
    ListAdapter<Show, ShowVH<*>>(MovieDiffCallback) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ShowVH<*> =
        if (viewType == 0) MovieVH.newInstance(viewGroup, onClick)
        else SerieVH.newInstance(viewGroup, onClick)

    override fun onBindViewHolder(viewHolder: ShowVH<*>, position: Int) {
        viewHolder.bind(this.getItem(position))
    }

    override fun getItemViewType(position: Int): Int =
        if (this.getItem(position) is Movie) 0
        else 1
}
