package com.example.broadcastapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class PowerReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        /*//if for checking incomming sms
        if (action == "android.provider.Telephony.SMS_RECEIVED") {
            Toast.makeText(context, "SMS Received", Toast.LENGTH_SHORT).show()
        }*/

        if (action == Intent.ACTION_POWER_DISCONNECTED) {
            Log.d("PowerReceiver", "onReceive: Power Disconnected")
            val i = Intent(context, AlarmService::class.java)
            i.action = "START"
            context.startService(i)
        }
        if (action == Intent.ACTION_POWER_CONNECTED) {
            Log.d("PowerReceiver", "onReceive: Power Connected")
            val i = Intent(context, AlarmService::class.java)
            context.stopService(i)
        }
    }
}