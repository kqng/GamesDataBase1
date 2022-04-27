package com.example.gamesdatabase.api

import com.example.gamesdatabase.Dto.GameDetailsResponseDto
import com.example.gamesdatabase.Dto.GamesResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgApi {
    @GET("lists/main")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("ordering") ordering: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<GamesResponseDto>

    @GET("{id}")
    suspend fun getGameDetails(
        @Path("id") gameId: Int,
        @Query("key") apiKey: String
    ): Response<GameDetailsResponseDto>

}