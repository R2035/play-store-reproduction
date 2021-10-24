package com.example.play.store.reproduction.di

import com.example.play.store.reproduction.screen.b01.GameFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    fun create(): Module {
        return module {
            viewModel { GameFragmentViewModel() }
        }
    }
}
