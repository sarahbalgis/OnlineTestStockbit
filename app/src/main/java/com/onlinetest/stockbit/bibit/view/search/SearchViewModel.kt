package com.onlinetest.stockbit.bibit.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Halaman Search"
    }
    val text: LiveData<String> = _text
}