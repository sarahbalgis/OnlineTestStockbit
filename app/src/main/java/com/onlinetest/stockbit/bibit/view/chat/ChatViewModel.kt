package com.onlinetest.stockbit.bibit.view.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Halaman Chat"
    }
    val text: LiveData<String> = _text
}