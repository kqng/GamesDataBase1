

package com.example.gamesdatabase

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { GamesViewModel(get()) }
    viewModel { GameViewModel(get()) }
}