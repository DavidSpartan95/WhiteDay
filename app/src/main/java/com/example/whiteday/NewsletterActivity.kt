package com.example.whiteday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import com.example.whiteday.databinding.ActivityNewsletterBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect

class NewsletterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsletterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsletterBinding.inflate(layoutInflater)

        setTheme(R.style.AppTheme)//change the app theme, thus statusbar turn cyan for this Activity
        setContentView(binding.root)

        val btnSubmit = binding.btnNewsletterSubmit
        val txtEmail = binding.editTextTextEmailAddress

        val emailFollowersViewModel by viewModels<EmailFollowersViewModel>()

        val snackbar = Snackbar.make(binding.root,"cancel subscription?", Snackbar.LENGTH_LONG).setAction("Undo",
            ){
            emailFollowersViewModel.removeEmail()
        }

        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                emailFollowersViewModel.uiState.collect(){
                    binding.txtNewsletterFollowers.text = "Followers: ${emailFollowersViewModel.uiState.value.arrEmail.size.toString()}"

                }
            }
        }
        btnSubmit.setOnClickListener {
            if (txtEmail.text.isNotEmpty()){
                emailFollowersViewModel.addEmail(txtEmail.text.toString())
                txtEmail.setText("")
                snackbar.show()
            }

        }
    }
}