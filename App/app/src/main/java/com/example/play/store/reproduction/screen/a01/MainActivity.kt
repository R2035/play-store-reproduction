package com.example.play.store.reproduction.screen.a01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.play.store.reproduction.R
import com.example.play.store.reproduction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = (supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment).navController
        binding.mainBottomNavigationView.setupWithNavController(navController)
    }
}
