package com.paulajustino.jokenpoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulajustino.jokenpoapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}