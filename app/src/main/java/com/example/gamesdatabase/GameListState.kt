package com.example.gamesdatabase

import com.example.gamesdatabase.models.GamesResponse

data class GamesListState(
    val isLoading: Boolean=false,
    val games: GamesResponse?=null,
    val error: String = ""
)