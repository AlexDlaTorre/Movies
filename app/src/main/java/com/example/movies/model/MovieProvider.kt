package com.example.movies.model

import android.content.Context
import com.example.movies.R
import com.example.movies.ui.MainActivity

object MovieProvider {
    fun initRecyclerView(mainActivity: MainActivity, context: Context) {
        with(context) {
            val moviesList = listOf(
                Movie(
                    getString(R.string.doctor_strange),
                    getString(R.string.may),
                    R.drawable.ic_strange,
                    70
                ),
                Movie(
                    getString(R.string.fantastic_beast),
                    getString(R.string.may),
                    R.drawable.ic_fantastic,
                    20
                ),
                Movie(getString(R.string.dog), getString(R.string.may), R.drawable.ic_strange, 40),
                Movie(
                    getString(R.string.sonic),
                    getString(R.string.may),
                    R.drawable.ic_fantastic,
                    50
                ),
                Movie(
                    getString(R.string.doctor_strange),
                    getString(R.string.may),
                    R.drawable.ic_strange,
                    90
                ),
            )

            /* mainActivity.binding.apply {
                 rvMovies.layoutManager = LinearLayoutManager(mainActivity)
                 rvMovies.adapter = MovieAdapter(moviesList)
                 rvPosters.layoutManager =
                     LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false)
                 rvPosters.adapter = PosterAdapter(moviesList)
             }*/
        }
    }
}