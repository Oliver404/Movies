package com.oliverbotello.movies.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Show

class MovieAdapter(private val onClick: (Show) -> Unit) :
    ListAdapter<Show, ShowVH<in Show>>(ShowDiffCallback) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ShowVH<in Show> =
        if (viewType != 1)
            MovieVH.newInstance(viewGroup, onClick) as ShowVH<in Show>
        else
            SerieVH.newInstance(viewGroup, onClick) as ShowVH<in Show>

    override fun onBindViewHolder(viewHolder: ShowVH<in Show>, position: Int) {
        viewHolder.bind(this.getItem(position))
    }

    override fun getItemViewType(position: Int): Int =
        if (this.getItem(position) is Movie)
            TypesShow.MOVIE.value
        else
            TypesShow.SERIE.value
}
