package com.example.gamesdatabase

import com.example.gamesdatabase.Repository.GameDetailsRepository
import com.example.gamesdatabase.Repository.GamesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<GamesRepository> { GamesRepositoryImpl(get()) }
    single<GameDetailsRepository> { GameDetailsRepositoryImpl(get()) }
}