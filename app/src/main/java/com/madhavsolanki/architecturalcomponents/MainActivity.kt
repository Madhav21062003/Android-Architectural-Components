package com.madhavsolanki.architecturalcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var countValue: TextView
    private lateinit var mainViewModel: MainViewModel

    // Implementing Live data
    private lateinit var liveDataViewModel: LiveDataViewModel
    private val factsTextView: TextView
        get() = findViewById(R.id.tvFact)

    private val btnUpdate:Button
        get() = findViewById(R.id.btnFact)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        lifecycle.addObserver(Observer())
        Log.d("Main ", "Activity On Create")


        // Implementing View Models
        countValue = findViewById(R.id.countValue)


        mainViewModel = ViewModelProvider(this, MainViewModelFactory(10)).get(MainViewModel::class.java)
        setText()

        // Live data implementation
        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
        liveDataViewModel.factsLiveData.observe(this, Observer{
            factsTextView.text = it
        })

        btnUpdate.setOnClickListener {
            liveDataViewModel.updateLiveData()
        }

    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()
    }

    private fun setText() {
        countValue.text = mainViewModel.count.toString()

    }


    // Using LifeCycle Observer with Activity Lifecycle methods
    override fun onResume() {
        super.onResume()
        Log.d("Main", "Activity On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main", "Activity On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main", "Activity OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main", "Activity OnDestroy")
    }


}