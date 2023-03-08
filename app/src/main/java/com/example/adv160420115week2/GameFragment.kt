package com.example.adv160420115week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        if(arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtName.text = "$playerName's Turn"
        }
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }
}