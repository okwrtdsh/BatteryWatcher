package com.github.okwrtdsh.batterywatcher

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.bindView

class MainActivity : AppCompatActivity() {
    val statusTextView: TextView by bindView(R.id.status)
    val timeTextView: TextView by bindView(R.id.time)
    val rateTextView: TextView by bindView(R.id.rate)
    val filter = IntentFilter().apply {
        addAction(Intent.ACTION_BATTERY_CHANGED)
    }
    val receiver = BatteryBroadcastReceiver {
        status, time, rate ->
        statusTextView.text = status
        timeTextView.text = time
        rateTextView.text = rate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}
