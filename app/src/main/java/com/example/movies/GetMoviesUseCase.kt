package com.example.movies

import com.example.movies.domain.MoviesServiceNetwork
import com.example.movies.model.ResultsModel
import retrofit2.Response

class GetMoviesUseCase {
    private val api = MoviesServiceNetwork()
    suspend fun getMoviesListInfo(): Response<ResultsModel> {
        return api.getMovieList()
    }
}

