package com.example.gamesdatabase

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import androidx.palette.graphics.Palette
import com.example.gamesdatabase.models.GamesResponse
import kotlinx.coroutines.*

class GamesViewModel constructor(private val getGamesUseCase: GetGamesUseCase) : ViewModel() {
//переделаь в LiveData
    val getGames: LiveData<GamesResponse>
    var gamesResponse: MutableLiveData<GamesResponse> = MutableLiveData()
    //private val repositoryImpl: GamesRepositoryImpl
    init {
       // var job: Job? = null
        //job =
            GlobalScope.launch{
                gamesResponse.postValue(getGamesUseCase.invoke(ordering = "relevance", page = 1, perPage = 5))
            }
        //job?.join()

        getGames = gamesResponse
        //getGames =dsf
    }
   /* private val _state = mutableStateOf(GamesListState())
    val state: MutableState<GamesListState> = _state

    init {
        getGames()
    }

    private fun getGames(){
        val gamesResponse = getGamesUseCase.invoke(ordering = "relevance", page = 1, perPage = 5)
        gamesResponse.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = GamesListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = GamesListState(games = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        GamesListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }*/

}