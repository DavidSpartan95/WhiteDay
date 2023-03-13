package com.example.whiteday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.whiteday.databinding.FragmentMainBinding


class MainFragment : Fragment() {
   private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        val view = binding.root

        binding.btnToAbout.setOnClickListener {//navigates to about screen
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_aboutFragment)

        }
        binding.btnToFunctionality.setOnClickListener {//navigates to Functionality screen
            Navigation.findNavController(view).navigate(R.id.functionalityActivity)

        }
        return view
    }

}