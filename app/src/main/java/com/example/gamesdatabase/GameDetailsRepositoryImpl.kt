package com.example.gamesdatabase

import com.example.gamesdatabase.Repository.GameDetailsRepository
import com.example.gamesdatabase.Repository.toDomain
import com.example.gamesdatabase.api.RawgApi
import com.example.gamesdatabase.models.GameDetailsResponse

class GameDetailsRepositoryImpl constructor(private val apiService: RawgApi) :
    GameDetailsRepository, SafeApiRequest() {

    override suspend fun getGameDetails(gameId: Int): GameDetailsResponse {

        println("GameId in gameDetailsRepoImpl: $gameId")

        val gameDetailsResponse = safeApiRequest {
            apiService.getGameDetails(
                apiKey = Constants.API_KEY,
                gameId = gameId
            )
        }

        return gameDetailsResponse.toDomain()
    }
}