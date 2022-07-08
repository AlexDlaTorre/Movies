package com.example.movies.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.extensions.CoroutineTestExtension
import com.example.movies.extensions.CoroutineTestExtensionWithMockDispatchers
import com.example.movies.extensions.InstantExecutorExtension
import com.example.movies.model.MovieModel
import com.example.movies.model.ResultsModel
import com.example.movies.usecase.GetMoviesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import retrofit2.Response
import java.util.*
import java.util.concurrent.CountDownLatch

@ExperimentalCoroutinesApi
@ExtendWith(
    MockKExtension::class,
    InstantExecutorExtension::class,
    CoroutineTestExtension::class,
    CoroutineTestExtensionWithMockDispatchers::class,
)
internal class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @InjectMockKs
    lateinit var viewModel: HomeViewModel

    @MockK
    lateinit var useCase: GetMoviesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `fetch Now Playing Happy Path`() {
        //GIVEN
        val response = Response.success(
            200,
            ResultsModel(
                1,
                listOf(
                    MovieModel(
                        297761,
                        "/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg",
                        "From DC Comics",
                        "Suicide Squad",
                        48.261451,
                        5.91,
                        "2016-08-03"
                    )
                )
            )
        )
        coEvery { (useCase.getMoviesListInfo()) } returns response
        //WHEN
        viewModel.getMovies()
        viewModel.movieModel.observe()
        //THEN
        Assert.assertEquals(1, viewModel.movieModel.value?.results?.size)
    }
}

