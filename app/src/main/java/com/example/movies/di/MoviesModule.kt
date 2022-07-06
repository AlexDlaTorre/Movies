package com.example.movies.di

import com.example.movies.GetMoviesUseCase
import com.example.movies.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val moviesModule: Module = module {
    viewModel { HomeViewModel(get()) }
    single { GetMoviesUseCase() }
}