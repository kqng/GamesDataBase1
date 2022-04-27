package com.example.gamesdatabase.Repository

import com.example.gamesdatabase.models.GameDetailsResponse

interface GameDetailsRepository {
    suspend fun getGameDetails(gameId:Int): GameDetailsResponse
}