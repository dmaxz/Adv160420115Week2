package com.example.adv160420115week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class GameOverFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtGameOver = view.findViewById<TextView>(R.id.txtGameOver)
        if(arguments != null) {
            val status =
                GameOverFragmentArgs.fromBundle(requireArguments()).status
            if (status){
                txtGameOver.text = "You Win"
            }
            else txtGameOver.text = "You Lose"
        }
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val action = GameOverFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}