package com.gleb64.noclick

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.view.accessibility.AccessibilityEvent


class MainAccessibilityService : AccessibilityService() {
    @SuppressLint("WearRecents")

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

    override fun onInterrupt() {

    }
    override fun onCreate() {
        val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        intentFilter.addAction(Intent.ACTION_DREAMING_STARTED)
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                //Log.d(null,intent.action.toString());
                if (intent.action == Intent.ACTION_DREAMING_STARTED) {
                    val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_MUTE,AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)
                } else if (intent.action == Intent.ACTION_SCREEN_OFF) {
                    val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_UNMUTE,AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)
                }
            }
        }, intentFilter)
    }
}