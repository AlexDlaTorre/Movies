package com.example.movies.adapter

import android.animation.ObjectAnimator
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.databinding.ItemMovieBinding
import com.example.movies.loadImage
import com.example.movies.model.MovieModel

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)

    fun render(movie: MovieModel) {
        with(binding) {
            val popularity = movie.popularity?.toInt()?.div(1000)
            tvTitle.text = movie.title
            tvDate.text = movie.release_date_detail
            movie.poster_path?.let { ivPoster.loadImage(it, Pair(100, 200)) }
            tvRate.text = popularity?.toString() + "%"
            progressBar.max = 10000
            //tvDate.text = movie.release_date.toString()



        val currentProgress = movie.popularity?.toInt()
        val progressBar = binding.progressBar
        if (currentProgress != null) {
            if (currentProgress <= 50) {
               Color.RED
            } else {
                Color.BLUE
            }
        }
        if (currentProgress != null) {
            ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(2000)
                .start()
        }
            }
    }
}