package com.example.modularizationapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.modularizationapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var homeFragment: BlankFragment
    lateinit var blankFragment1: BlankFragment1
    lateinit var blankFragment2: BlankFragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        homeFragment = BlankFragment()
        blankFragment1 = BlankFragment1()
        blankFragment2 = BlankFragment2()

        bottomNavigationView = binding.btmNavBar
        loadFragment(BlankFragment())
        bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.Home -> {
                    loadFragment(homeFragment)
                }

                R.id.Movies -> {
                    loadFragment(blankFragment1)
                }

                R.id.Pokedex -> {
                    loadFragment(blankFragment2)
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
}