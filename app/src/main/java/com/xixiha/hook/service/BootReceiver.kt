package com.xixiha.hook.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_BOOT_COMPLETED
import com.xixiha.hook.utils.Data.runService
import com.xixiha.hook.utils.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            ACTION_BOOT_COMPLETED,
            "com.xixiha.hook.service.StartService" -> {
                context?.runService()
            }

            else -> intent?.action?.let { Log.d("BootReceiver",it) }
        }
    }
}