package com.example.clickcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> get() = _counter

    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }
}
