package com.example.gamesdatabase

import com.example.gamesdatabase.Repository.GamesRepository
import com.example.gamesdatabase.Repository.toDomain
import com.example.gamesdatabase.api.RawgApi
import com.example.gamesdatabase.models.GamesResponse

class GamesRepositoryImpl constructor(private val apiService: RawgApi) : GamesRepository,
    SafeApiRequest() {

    override suspend fun getGames(ordering: String, page: Int, perPage: Int): GamesResponse {
        println("Game in gameRepoImpl")

        val getGamesResponse = safeApiRequest {
            apiService.getGames(
                apiKey = Constants.API_KEY,
                ordering = ordering,
                page = page,
                perPage = perPage
            )
        }
        return getGamesResponse.toDomain()
    }
}