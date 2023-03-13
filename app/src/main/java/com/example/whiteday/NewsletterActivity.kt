package com.example.whiteday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewsletterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)//this will change the app theme, and in turn change statusbar to cyan
        setContentView(R.layout.activity_newsletter)
    }
}