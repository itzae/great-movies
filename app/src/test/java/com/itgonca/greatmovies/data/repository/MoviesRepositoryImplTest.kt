package com.itgonca.greatmovies.data.repository

import com.itgonca.greatmovies.data.network.MoviesRemoteSource
import com.itgonca.greatmovies.data.network.model.Movie
import com.itgonca.greatmovies.data.network.model.MovieResponse
import com.itgonca.greatmovies.domain.repository.MoviesRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class MoviesRepositoryImplTest {

    @MockK(relaxed = true)
    lateinit var moviesRemoteSource: MoviesRemoteSource

    lateinit var moviesRepository: MoviesRepository

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        moviesRepository = MoviesRepositoryImpl(moviesRemoteSource, testDispatcher)
    }

    @Test
    fun `get trending movies successfully`() = testDispatcher.runBlockingTest {

        val response = mockk<MovieResponse<Movie>>(relaxed = true)

        coEvery { moviesRemoteSource.getTrendingMovies() } returns response

        val testResponse = moviesRepository.getTrendingMovies().last()

        Assert.assertEquals(response, testResponse)
    }
}