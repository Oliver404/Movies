package com.oliverbotello.movies.ui.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.models.Show
import com.oliverbotello.movies.ui.adapters.MovieAdapter
import com.oliverbotello.movies.utils.toDate
import com.oliverbotello.movies.utils.toStringFormat
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initView()
        this.viewModel.initMovies()
    }

    private fun initView() {
        val adapter: MovieAdapter =
            MovieAdapter({ movie -> this.onSelectItem(movie) })
        this.rcclrcVw_Movies.adapter = adapter
        this.viewModel?.let { it ->
            it.bussy.observe(this) {
                this.pgrssBr.visibility = if (it) View.VISIBLE else View.GONE
            }
            it.lstShows.observe(this) {
                it.let {
                    adapter.submitList(it)

                    if (it.size > 0) this.onSelectItem(it[0])
                }
            }
        }
    }

    private fun onSelectItem(show: Show) {
        this.txtVw_SelectedTitle.text = show.title
        this.txtVw_SelectedDate.text = show.getDate()
        this.txtVw_Description.text = show.overview

        Glide
            .with(this.imgVw_Poster.context)
            .load(show.getPosterUrl(true))
            .placeholder(R.drawable.ic_movie)
            .into(this.imgVw_MiniPoster)
        Glide
            .with(this.imgVw_Poster.context)
            .load(show.getPosterUrl())
            .placeholder(R.drawable.ic_movie)
            .into(this.imgVw_Poster)
    }
}