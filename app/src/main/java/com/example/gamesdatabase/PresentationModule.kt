

package com.example.gamesdatabase

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val presentationModule = module {
    viewModel { GamesViewModel(get()) }
    viewModel { GameViewModel(get()) }
}
val loadPresentationModule by lazy {
    val modules = listOf(presentationModule)
    loadKoinModules(modules)
}