package com.example.movies

import android.icu.util.TimeUnit.values
import com.example.movies.model.MovieModel
import com.example.movies.model.ResultsModel
import com.example.movies.ui.HomeViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @MockK
    lateinit var viewModel: HomeViewModel

    @MockK
    lateinit var useCase: GetMoviesUseCase

    @Before
    fun setUp() {
        viewModel = HomeViewModel(useCase)
    }

    @Test
    fun fetchNowPlayingHappyPath() {
        //GIVEN
        val case = mockk<GetMoviesUseCase>(){
            coEvery {(useCase.getMoviesListInfo())} returns (ResultsModel(0, listOf(MovieModel(15,))))
        }
        //WHEN
        viewModel.getMovies()
        //THEN
        assertEquals(1, viewModel.movieModel.value?.results?.size)
    }

    private fun every(stubBlock: Response<ResultsModel>): Any {

    }
}