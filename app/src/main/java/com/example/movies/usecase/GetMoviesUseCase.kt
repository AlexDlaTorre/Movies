package com.example.movies.usecase

import com.example.movies.domain.MoviesServiceNetwork
import com.example.movies.model.ResultsModel
import retrofit2.Response

class GetMoviesUseCase {
    val api = MoviesServiceNetwork()
    suspend fun getMoviesListInfo(): Response<ResultsModel> {
        return api.getMovieList()
    }
}

