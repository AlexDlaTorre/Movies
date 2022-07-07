package com.example.movies.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.usecase.GetMoviesUseCase
import com.example.movies.model.ResultsModel
import com.example.movies.usecase.GetNowPlayingUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
   val getMoviesUseCase: GetMoviesUseCase = GetMoviesUseCase(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val movieModel = MutableLiveData<ResultsModel>()

    fun getMovies() {
        viewModelScope.launch(dispatcher) {
            val response = getMoviesUseCase.getMoviesListInfo()
            if (response.isSuccessful) {
                movieModel.postValue(response.body())
            }

        }
    }

}