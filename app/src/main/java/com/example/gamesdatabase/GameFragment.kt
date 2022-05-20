package com.example.gamesdatabase

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.Contacts
import android.util.Log
import android.util.Log.INFO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesdatabase.Repository.GamesRepository
import com.example.gamesdatabase.api.RawgApi
import com.example.gamesdatabase.models.Game
import com.example.gamesdatabase.models.GamesResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import okhttp3.internal.wait
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class GameFragment: Fragment() {
    private lateinit var gamesViewModel: GamesViewModel // = getSharedViewModel()
    private lateinit var gameRecycleView: RecyclerView
    private lateinit var gameViewModel: GameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gamesViewModel = getViewModel()
        gameViewModel = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_item,container,false)
        gameRecycleView = view.findViewById(R.id.game_recycle_view)
        gameRecycleView.layoutManager = LinearLayoutManager(context)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gamesViewModel.getGames.observe(viewLifecycleOwner, Observer {
                game ->
            val gameList = game.results
            gameRecycleView.adapter = GameAdapter(gameList)

        })

    }
    private class GameHolder(val gameItemView: View) : RecyclerView.ViewHolder(gameItemView){
        val gameImage: ImageView = gameItemView.findViewById(R.id.imageView)
        val bindDrawable: (Drawable) -> Unit = gameImage::setImageDrawable
        val titleText: TextView = gameItemView.findViewById(R.id.textView)
        val bindTitle: (CharSequence) -> Unit = titleText::setText
        val rowLayout: ConstraintLayout = gameItemView.findViewById(R.id.rowLayout)
    }
    private inner class GameAdapter(private var gameItems: List<Game>?) : RecyclerView.Adapter<GameHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
            val view = layoutInflater.inflate(
                R.layout.list_game_item,
                parent,
                false
            )// as ImageView
            return GameHolder(view)
        }

        override fun onBindViewHolder(holder: GameHolder, position: Int) { //сюда данные для вывода
            val gameItem = gameItems?.get(position)
            val imageView = holder.gameImage
            if (gameItem != null) {
                Picasso.get()
                    .load(gameItem.background_image)
                    .resize(1000, 500)
                    .centerCrop()
                    .into(imageView)
            }
            else {
                val placeholder: Drawable = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.no_img
            ) ?: ColorDrawable()
            holder.bindDrawable(placeholder)
            }
            gameItem?.name?.let { holder.bindTitle(it) }
            holder.rowLayout.setOnClickListener {
                gameViewModel.getGameDetails(gameItem!!.id!!)
                if (gameViewModel.state.value.gameDetails != null){
                val gameState = gameViewModel.state.value
                val game = gameState.gameDetails
                val action = GameFragmentDirections.listToCard(game!!)
                holder.gameItemView.findNavController().navigate(action)
            }
            }
            //?
        }
        override fun getItemCount(): Int = gameItems?.size!!
    }
    companion object{
        fun newInstance() = GameFragment()
    }
}