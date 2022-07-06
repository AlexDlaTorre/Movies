package com.example.movies

import com.example.movies.domain.MoviesServiceNetwork

class MoviesRepository {
    private val api = MoviesServiceNetwork()

    suspend fun getMoviesListInfo() {
        val response = api.getMovieList()
    }
}
