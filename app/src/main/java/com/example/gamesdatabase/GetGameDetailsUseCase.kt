package com.example.gamesdatabase

import com.example.gamesdatabase.Repository.GameDetailsRepository
import com.example.gamesdatabase.models.GameDetailsResponse

class GetGameDetailsUseCase constructor(private val gameDetailsRepository: GameDetailsRepository) {
    suspend operator fun invoke(gameId: Int): Resource<GameDetailsResponse> {
        val gamesDetailsResponse = gameDetailsRepository.getGameDetails(gameId = gameId)
        return Resource.Success(gamesDetailsResponse)
    }
}