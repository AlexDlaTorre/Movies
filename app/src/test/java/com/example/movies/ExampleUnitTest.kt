package com.example.movies

import com.example.movies.extensions.CoroutineTestExtension
import com.example.movies.extensions.CoroutineTestExtensionWithMockDispatchers
import com.example.movies.extensions.InstantExecutorExtension
import com.example.movies.model.MovieModel
import com.example.movies.model.ResultsModel
import com.example.movies.ui.HomeViewModel
import com.example.movies.usecase.GetMoviesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

}