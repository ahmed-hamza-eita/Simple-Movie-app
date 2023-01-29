package com.hamza.hilt_navigation.services

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.R
import com.hamza.hilt_navigation.ui.MainActivity
import com.hamza.hilt_navigation.ui.adapters.MoviesAdapter
import com.hamza.hilt_navigation.ui.home.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyServices : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        sendDataToActivity()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val mBuilder = NotificationCompat.Builder(this, Const.NFT_CHANNEL)
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            mBuilder.setContentText("App is running")
            mBuilder.setContentTitle("TEST ForeGround Services")
            startForeground(System.currentTimeMillis().toInt(), mBuilder.build())
        } else {
            val mBuilder = NotificationCompat.Builder(this, "test")
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
            mBuilder.setContentText("App is running")
            mBuilder.setContentTitle("TEST ForeGround Services")
            startForeground(1, mBuilder.build())
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopForeground(true)
    }

    private fun sendDataToActivity() {
        val intent = Intent(Const.ACTIONS_FILTER)
        CoroutineScope(IO).launch {
            for (i in 1..8) {
                delay(1000)
                intent.putExtra(Const.KEY, i)
                LocalBroadcastManager.getInstance(this@MyServices).sendBroadcast(intent)

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}