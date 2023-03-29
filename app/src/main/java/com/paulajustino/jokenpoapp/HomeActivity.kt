package com.paulajustino.jokenpoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulajustino.jokenpoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setClickListeners()
    }

    private fun setClickListeners() {
        binding.startButton.setOnClickListener {
            val playerActivityIntent = Intent(this, PlayerActivity::class.java)
            startActivity(playerActivityIntent)
        }
    }
}