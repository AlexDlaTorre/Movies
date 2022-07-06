package com.example.movies.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.loadImage
import com.example.movies.model.MovieModel

class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val poster = view.findViewById<ImageView>(R.id.ivPoster)

    fun render(movie: MovieModel) {
        movie.poster_path?.let { poster.loadImage(it, Pair(100, 200)) }
    }
}