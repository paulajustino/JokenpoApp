package com.paulajustino.jokenpoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.paulajustino.jokenpoapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpActionBar()
        setUpDrawer()
    }

    private fun setUpActionBar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_drawer)
    }

    private fun setUpDrawer() {
        drawer = binding.root
        navDrawer = binding.navView

        navDrawer.setNavigationItemSelectedListener { drawerMenuItem ->
            drawer.closeDrawers() // metodo que fecha o drawer menu depois da seleção do item
            when (drawerMenuItem.itemId) {
                R.id.drawer_home -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                else -> false
            }
        }
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

    override fun onSupportNavigateUp(): Boolean {
        // necessario inserir de que direçao ele vai abrir
        drawer.openDrawer(GravityCompat.START)
        return true
    }
}