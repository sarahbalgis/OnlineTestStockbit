package com.onlinetest.stockbit.bibit.view.stream

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StreamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Halaman Stream"
    }
    val text: LiveData<String> = _text
}