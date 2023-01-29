package com.hamza.hilt_navigation

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        channel()
    }

    private fun channel() {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val nftChannel =
                    NotificationChannel(
                        Const.NFT_CHANNEL, "test",
                        NotificationManager.IMPORTANCE_HIGH
                    )

                val manager = getSystemService(NotificationManager::class.java)

                manager.createNotificationChannel(nftChannel)
            }
    }

}