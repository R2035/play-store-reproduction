package com.example.play.store.reproduction.di

import com.example.play.store.reproduction.screen.b01.GameFragmentViewModel
import com.example.play.store.reproduction.screen.c01.AppFragmentViewModel
import com.example.play.store.reproduction.screen.d01.BookFragmentViewModel
import com.example.play.store.reproduction.screen.e01.MovieFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    fun create(): Module {
        return module {
            viewModel { GameFragmentViewModel() }
            viewModel { AppFragmentViewModel() }
            viewModel { BookFragmentViewModel() }
            viewModel { MovieFragmentViewModel() }
        }
    }
}
