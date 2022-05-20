package com.example.gamesdatabase

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso

class FragmentGameCard : Fragment() {
private val args by navArgs<FragmentGameCardArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_card,container,false)
        val img: ImageView = view.findViewById(R.id.imageView3)
        val bindDrawable: (Drawable) -> Unit = img::setImageDrawable
        val tvName: TextView = view.findViewById(R.id.tvIdGame)
        val tvDisc: TextView = view.findViewById(R.id.tvDis)
        if (args != null) {
            Picasso.get()
                .load(args.gameItem.backgroundImage)
                .resize(1000, 500)
                .centerCrop()
                .into(img)
            tvName.text = args.gameItem.name
            tvDisc.text = args.gameItem.descriptionRaw
        }
        else {
            val placeholder: Drawable = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.no_img
            ) ?: ColorDrawable()
            bindDrawable(placeholder)
            tvName.text = ""
            tvDisc.text =""
        }
        // Inflate the layout for this fragment
        return view

    }


    companion object {

        fun newInstance() = FragmentGameCard()
    }
}
