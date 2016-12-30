package com.github.okwrtdsh.batterywatcher

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import java.text.SimpleDateFormat
import java.util.*

class BatteryBroadcastReceiver(val showStatus: (status: String, time: String, rate: String) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action == Intent.ACTION_BATTERY_CHANGED) {
            /*
            Log.v("Battery Watcher",
                when (intent.getIntExtra("status", 0)) {
                    BatteryManager.BATTERY_STATUS_UNKNOWN      -> "unknown"
                    BatteryManager.BATTERY_STATUS_CHARGING     -> "charging"
                    BatteryManager.BATTERY_STATUS_DISCHARGING  -> "discharging"
                    BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "not charging"
                    BatteryManager.BATTERY_STATUS_FULL         -> "full"
                    else                                       -> "other"
                } + SimpleDateFormat(": yyyy/MM/dd hh:mm:ss", Locale.getDefault()).format(Date())
            )
            */
            showStatus(
                when (intent.getIntExtra("status", 0)) {
                    BatteryManager.BATTERY_STATUS_UNKNOWN      -> "unknown"
                    BatteryManager.BATTERY_STATUS_CHARGING     -> "charging"
                    BatteryManager.BATTERY_STATUS_DISCHARGING  -> "discharging"
                    BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "not charging"
                    BatteryManager.BATTERY_STATUS_FULL         -> "full"
                    else                                       -> "other"
                },
                SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Date()),
                "${intent.getIntExtra("level", 0)} / ${intent.getIntExtra("scale", 0)}"
            )
        }
    }
}