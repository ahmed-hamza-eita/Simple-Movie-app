package com.hamza.hilt_navigation.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.databinding.ActivityMainBinding
import com.hamza.hilt_navigation.services.MyIntentService
import com.hamza.hilt_navigation.services.MyServices
import com.hamza.hilt_navigation.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var myCast = MyCast()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        initServices()
        getDataFromService()
    }

    private fun initServices() {
        //start Background Service
        val intent = Intent(this, MyServices::class.java)
        startService(intent)
        //Start Foreground Service
        val intentFG = Intent(this, MyServices::class.java)
        ContextCompat.startForegroundService(this, intentFG)

        //Start Intent Service
        val intentService = Intent(this, MyIntentService::class.java)
        startService(intentService)
    }


    inner class MyCast : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.e("TAG", "onReceive${intent?.getIntExtra(Const.KEY,1)}")
        }
    }

    private fun getDataFromService() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Const.ACTIONS_FILTER)
        LocalBroadcastManager.getInstance(this).registerReceiver(myCast, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

        LocalBroadcastManager.getInstance(this).unregisterReceiver(myCast)
    }
}