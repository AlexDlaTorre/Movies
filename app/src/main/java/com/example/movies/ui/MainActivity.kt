package com.example.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapter.MovieAdapter
import com.example.movies.adapter.PosterAdapter
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.model.ResultsModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModel<HomeViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        observers()
    }

    private fun observers() {
        homeViewModel.movieModel.observe(this, ::initRecyclerView2)
        homeViewModel.getMovies()
    }

    private fun initRecyclerView2(movieList: ResultsModel) {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = MovieAdapter(movieList.results)
        binding.rvPosters.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPosters.adapter = PosterAdapter(movieList.results)
    }
}