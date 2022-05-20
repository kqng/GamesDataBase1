package com.example.gamesdatabase


import androidx.lifecycle.LiveData
import com.example.gamesdatabase.Repository.GamesRepository
import com.example.gamesdatabase.models.GamesResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class GetGamesUseCase constructor(private val gameRepository: GamesRepository) {


    suspend operator fun invoke(ordering: String, page: Int, perPage: Int):GamesResponse =
            gameRepository.getGames(ordering, page, perPage)



    /*flow {
               //try {

               emit(Resource.Loading())
               val gamesResponse = gameRepository.getGames(ordering, page, perPage)
               emit(Resource.Success(gamesResponse))

           }*/
       }
