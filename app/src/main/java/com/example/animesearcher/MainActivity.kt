package com.example.animesearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.animesearcher.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
        val navController = navHostFragment.navController;

        binding.bottomNavigationView.setupWithNavController(navController);

//
//        val navView: BottomNavigationView = binding.bottomNavigationView
//        val navController = findNavController(R.id.mainActivityNavHost);
//
//        val appBarConfiguration= AppBarConfiguration(setOf(R.id.listFragment,R.id.likedAnimeFragment));
//        setupActionBarWithNavController(navController,appBarConfiguration);
//
//        navView.setupWithNavController(navController);

    }
}