package com.paulajustino.jokenpoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulajustino.jokenpoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.startButton.setOnClickListener {
            val activity2Intent = Intent(this, MainActivity2::class.java)
            startActivity(activity2Intent)
        }
    }

    // Outra forma de configurar o botao é atraves de um meta-data dentro da activity no manifest
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}