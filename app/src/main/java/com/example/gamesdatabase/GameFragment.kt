package com.example.gamesdatabase

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesdatabase.models.Game
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel

class GameFragment: Fragment() {
    private var gamesViewModel: GamesViewModel = getSharedViewModel()
    private lateinit var gameRecycleView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gamesViewModel = ViewModelProvider(this).get(GamesViewModel::class.java)
        //gamesViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //obs
        val view = inflater.inflate(R.layout.fragment_game_item,container,false)
        gameRecycleView = view.findViewById(R.id.game_recycle_view)
        gameRecycleView.layoutManager = LinearLayoutManager(context)//GridLayoutManager(context,3)
        val gamesState = gamesViewModel.state.value//ошибка
        val gameList = gamesState.games?.results
        gameRecycleView.adapter = GameAdapter(gameList)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private class GameHolder(private val gameItemView: View) : RecyclerView.ViewHolder(gameItemView){
        val gameImage: ImageView = gameItemView.findViewById(R.id.imageView)
        val bindDrawable: (Drawable) -> Unit = gameImage::setImageDrawable
        val titleText: TextView = gameItemView.findViewById(R.id.textView)
        val bindTitle: (CharSequence) -> Unit = titleText::setText
    }
    private inner class GameAdapter(private val gameItems: List<Game>?) : RecyclerView.Adapter<GameHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
            val view = layoutInflater.inflate(
                R.layout.list_game_item,
                parent,
                false
            ) //as ImageView
            return GameHolder(view)
        }

        override fun getItemCount(): Int = gameItems?.size!!
        override fun onBindViewHolder(holder: GameHolder, position: Int) { //сюда данные для вывода
            val gameItem = gameItems?.get(position)
            val placeholder: Drawable = ContextCompat.getDrawable(
                requireContext(),R.drawable.no_img) ?: ColorDrawable()
            holder.bindDrawable(placeholder)
            gameItem?.name?.let { holder.bindTitle(it) }
            //?
        }
    }
    companion object{
        fun newInstance() = GameFragment()
    }
}