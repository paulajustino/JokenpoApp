package com.paulajustino.jokenpoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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

    // vincula o menu à activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // configura comportamento ao item selecionado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_save -> {
                Snackbar.make(
                    this,
                    binding.root,
                    getText(R.string.menu_save_title),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            R.id.menu_settings -> {
                Snackbar.make(
                    this,
                    binding.root,
                    getText(R.string.menu_settings_title),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            else -> false
        }
    }
}