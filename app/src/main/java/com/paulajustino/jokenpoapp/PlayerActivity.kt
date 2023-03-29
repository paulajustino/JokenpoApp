package com.paulajustino.jokenpoapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.paulajustino.jokenpoapp.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpActionBar()
        setUpNavView()
        setUpBottomNavView()
    }

    // configura actionBar personalizada
    private fun setUpActionBar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_drawer)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // configura o botao que fica à esquerda na actionBar
    override fun onSupportNavigateUp(): Boolean {
        // necessario inserir de que direçao ele vai abrir
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    // vincula o menu que fica à direita na actionBar à activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // configura comportamento ao item selecionado do menu à direita na actionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_restart -> {
                val homeActivityIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeActivityIntent)
                true
            }
            else -> false
        }
    }

    // configura menu hamburguer
    private fun setUpNavView() {
        drawer = binding.root
        navView = binding.navView

        navView.setNavigationItemSelectedListener { navMenuItem ->
            drawer.closeDrawers() // metodo que fecha o drawer menu depois da seleção do item
            when (navMenuItem.itemId) {
                R.id.nav_player -> {
                    val playerActivityIntent =
                        Intent(this, PlayerActivity::class.java)
                    startActivity(playerActivityIntent)
                    true
                }
                R.id.nav_result -> {
                    val resultActivityIntent =
                        Intent(this, ResultActivity::class.java)
                    startActivity(resultActivityIntent)
                    true
                }
                else -> false
            }
        }
    }

    // configura bottom navigation
    private fun setUpBottomNavView() {
        bottomNavView = binding.bottomNavView

        bottomNavView.setOnItemSelectedListener { bottomNavMenuItem ->
            when (bottomNavMenuItem.itemId) {
                R.id.bottom_player -> {
                    val playerActivityIntent =
                        Intent(this, PlayerActivity::class.java)
                    startActivity(playerActivityIntent)
                    true
                }
                R.id.bottom_result -> {
                    val resultActivityIntent =
                        Intent(this, ResultActivity::class.java)
                    startActivity(resultActivityIntent)
                    true
                }
                else -> false
            }
        }
    }
}