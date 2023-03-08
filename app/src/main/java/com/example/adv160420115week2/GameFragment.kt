package com.example.adv160420115week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlin.random.Random

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
//        val btnBack = view.findViewById<Button>(R.id.btnBack)
//        btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
        val num1 = Random.nextInt(0, 100)
        val num2 = Random.nextInt(0, 100)
        val result = num1 + num2
        view.findViewById<TextView>(R.id.txtQuestion).text = "$num1 + $num2"
        val btnCheck = view.findViewById<Button>(R.id.btnCheck)
        var status = false // lose the game
        btnCheck.setOnClickListener {
            val numTotal = view.findViewById<EditText>(R.id.numTotal)
            if (Integer.parseInt(numTotal.text.toString()) == result){
                status = true // win the game
            }
            val action = GameFragmentDirections.actionGameOverFragment(status)
            Navigation.findNavController(it).navigate(action)
        }
    }
}