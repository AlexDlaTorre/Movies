package com.example.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.model.MovieModel

class PosterAdapter(private val moviesList: List<MovieModel>) :
    RecyclerView.Adapter<PosterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)
        return PosterViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val item = moviesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = moviesList.size
}