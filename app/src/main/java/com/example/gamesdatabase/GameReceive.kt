package com.example.gamesdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamesdatabase.GameItem

class GameReceive {
    fun receiveGames(): LiveData<List<GameItem>>{
        val responseLiveData: MutableLiveData<List<GameItem>> = MutableLiveData()
        return responseLiveData
    }
}