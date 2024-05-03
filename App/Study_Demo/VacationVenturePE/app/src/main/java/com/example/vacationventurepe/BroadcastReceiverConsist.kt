package com.example.vacationventurepe

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter

data class BroadcastReceiverConsist(
    val broadcastReceiver: BroadcastReceiver,
    val intent: IntentFilter,
    val broadType:Int
)
