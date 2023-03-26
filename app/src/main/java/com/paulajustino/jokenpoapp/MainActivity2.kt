package com.paulajustino.jokenpoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.paulajustino.jokenpoapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var drawer: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpActionBar()
        setUpNavView()
        setUpBottomNavView()
    }

    private fun setUpActionBar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_drawer)
    }

    private fun setUpNavView() {
        drawer = binding.root
        navView = binding.navView

        navView.setNavigationItemSelectedListener { navMenuItem ->
            drawer.closeDrawers() // metodo que fecha o drawer menu depois da seleção do item
            when (navMenuItem.itemId) {
                R.id.nav_home -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                else -> false
            }
        }
    }

    private fun setUpBottomNavView() {
        bottomNavView = binding.bottomNavView

        bottomNavView.menu[0].isCheckable = false
        bottomNavView.setOnItemSelectedListener { bottomNavMenuItem ->
            when (bottomNavMenuItem.itemId) {
                R.id.bottom_home -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }
                R.id.bottom_profile -> {
                    Snackbar.make(
                        binding.root,
                        getText(R.string.menu_profile_title),
                        Snackbar.LENGTH_SHORT
                    ).show()
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