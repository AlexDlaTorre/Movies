package com.example.movies.api

import com.example.movies.model.ResultsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {

    /* @GET("/movie/now_playing")
     suspend fun getNowPlayingMovies(
         @Query("api_key") api_key: String
     ): Response<ResultsModel>*/

    @GET("movie/popular/")
    suspend fun getMostPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<ResultsModel>
}