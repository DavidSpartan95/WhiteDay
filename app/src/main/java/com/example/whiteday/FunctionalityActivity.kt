package com.example.whiteday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whiteday.databinding.ActivityFunctionalityBinding

class FunctionalityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFunctionalityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFunctionalityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bellow is were all the animations are
        binding.imgStrawberry.setOnClickListener {
            binding.imgStrawberry.animate().apply {
                duration = 500
                rotationBy(360f)
            }.start()
        }
        binding.imgChocolateBar.setOnClickListener {
            binding.imgChocolateBar.animate().apply {
                duration = 250
                translationY(-100f)
                withEndAction{
                    translationYBy(200f)
                    withEndAction{
                        translationY(0f)
                    }
                }
            }.start()
        }
        binding.imgIceCream.setOnClickListener {
            binding.imgIceCream.animate().apply {
                duration = 500
                rotationBy(-360f)
            }.start()
        }
        binding.imgWhiteStrawberry.setOnClickListener {
            binding.imgWhiteStrawberry.animate().apply {
                duration = 500
                rotationBy(-720f)
            }.start()
        }
    }
}