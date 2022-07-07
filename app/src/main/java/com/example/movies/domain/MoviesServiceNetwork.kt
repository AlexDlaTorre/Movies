package com.example.movies.domain

import android.util.Log
import com.example.movies.api.MovieApiClient
import com.example.movies.api.RetrofitInstance
import com.example.movies.model.ResultsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesServiceNetwork {
     val retrofit = RetrofitInstance.getRetrofit().create(MovieApiClient::class.java)

   /* suspend fun getNowPlayingList(): Response<ResultsModel> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.getNowPlayingMovies("46c2918de0b920f332babd08329da6c3")
            Log.d("MovieListResponse", response.body().toString())
            response
        }
    }*/

    suspend fun getMovieList(): Response<ResultsModel> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.getMostPopularMovies("46c2918de0b920f332babd08329da6c3", "en-US", 1)
            response
        }
    }
}

