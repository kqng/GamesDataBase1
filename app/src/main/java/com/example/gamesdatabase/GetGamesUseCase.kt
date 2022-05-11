package com.example.gamesdatabase


import com.example.gamesdatabase.Repository.GamesRepository
import com.example.gamesdatabase.models.GamesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGamesUseCase constructor(private val gameRepository: GamesRepository) {

    operator fun invoke(ordering: String, page: Int, perPage: Int): Flow<Resource<GamesResponse>> =
        flow {
            //try {

            emit(Resource.Loading())
            val gamesResponse = gameRepository.getGames(ordering, page, perPage)
            emit(Resource.Success(gamesResponse))

        }
}