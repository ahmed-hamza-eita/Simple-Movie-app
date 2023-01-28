package com.hamza.hilt_navigation.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.hamza.hilt_navigation.ui.adapters.MoviesAdapter
import com.hamza.hilt_navigation.ui.home.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyServices:Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return  null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}