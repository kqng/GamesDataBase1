package com.example.gamesdatabase

import com.example.gamesdatabase.models.GameDetailsResponse

data class GameDetailState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetailsResponse? = null,
    val error: String = ""
)
