package com.hamza.hilt_navigation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hamza.hilt_navigation.databinding.ActivityMainBinding
import com.hamza.hilt_navigation.services.MyServices
import com.hamza.hilt_navigation.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        val intent= Intent( this,MyServices::class.java)
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}