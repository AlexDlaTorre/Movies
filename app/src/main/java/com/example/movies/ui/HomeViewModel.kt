package com.example.movies.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.GetMoviesUseCase
import com.example.movies.model.ResultsModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase = GetMoviesUseCase(),
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