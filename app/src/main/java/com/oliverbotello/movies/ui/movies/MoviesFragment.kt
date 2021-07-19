package com.oliverbotello.movies.ui.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.oliverbotello.movies.MainViewModel
import com.oliverbotello.movies.R
import com.oliverbotello.movies.models.Movie
import com.oliverbotello.movies.ui.adapters.MovieAdapter
import com.oliverbotello.movies.utils.toStringFormat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_movie_layout.view.*
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
        this.viewModel?.initMovies()
    }

    private fun initView() {
        val adapter: MovieAdapter =
            MovieAdapter({ movie -> this.onClickItem(movie) })
        this.rcclrcVw_Movies.adapter = adapter
        this.viewModel?.let {
            it.bussy.observe(this) {
                this.pgrssBr.visibility = if (it) View.VISIBLE else View.GONE
            }
            it.lstMovies.observe(this) {
                adapter.submitList(it)
            }
        }
    }

    private fun onClickItem(movie: Movie) {
        val idImage = this.resources.getIdentifier(
            movie.posterPath.replace(".jpg", ""),
            "drawable",
            this.context?.packageName
        )
        this.txtVw_SelectedTitle.text = movie.title
        this.txtVw_SelectedDate.text = movie.releaseDate.toStringFormat()
        this.txtVw_Description.text = movie.description
        Glide
            .with(this.imgVw_Poster.context)
            .load(this.imgVw_Poster.context.getDrawable(idImage))
            .placeholder(R.drawable.ic_movie)
            .into(this.imgVw_MiniPoster)
        Glide
            .with(this.imgVw_Poster.context)
            .load(this.imgVw_Poster.context.getDrawable(idImage))
            .placeholder(R.drawable.ic_movie)
            .into(this.imgVw_Poster)
    }
}