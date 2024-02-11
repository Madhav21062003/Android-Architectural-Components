package com.madhavsolanki.architecturalcomponents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel: ViewModel() {

    val factsLiveData = MutableLiveData<String>("This is a fact")

    fun updateLiveData(){
        factsLiveData.value = "Another Fact"
    }
}