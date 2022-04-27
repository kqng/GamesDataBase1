package com.example.gamesdatabase

import org.koin.dsl.module

val domainModule = module {
    single { GetGamesUseCase(get()) }
    single { GetGameDetailsUseCase(get()) }
}
