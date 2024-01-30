package com.madhavsolanki.architecturalcomponents

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class Observer: DefaultLifecycleObserver {


    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("Main", "Observer- ON Create")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("Main", "Observer- ON Resume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("Main", "Observer- ON Pause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("Main", "Observer- ON Stop")
    }
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("Main", "Observer- ON Destroy")
    }
}