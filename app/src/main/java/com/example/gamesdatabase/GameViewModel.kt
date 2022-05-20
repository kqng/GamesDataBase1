package com.example.gamesdatabase

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GameViewModel constructor(private val getGameDetailsUseCase: GetGameDetailsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(GameDetailState())
    val state: State<GameDetailState> = _state
    fun getGameDetails(gameId: Int) {
        viewModelScope.launch {
            val result = getGameDetailsUseCase.invoke(gameId = gameId)

            when (result) {
                is Resource.Loading -> {
                    _state.value = GameDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = GameDetailState(gameDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        GameDetailState(error = result.message ?: "An unexpected error occurred")
                }

            }
        }
    }

}