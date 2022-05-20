package com.example.gamesdatabase.Repository

import androidx.lifecycle.LiveData
import com.example.gamesdatabase.models.GamesResponse

interface GamesRepository {
    suspend fun getGames(ordering:String, page:Int, perPage:Int): GamesResponse

}