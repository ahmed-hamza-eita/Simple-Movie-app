package com.hamza.hilt_navigation.services

import android.content.Intent
import androidx.core.app.JobIntentService

class MyIntentService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}