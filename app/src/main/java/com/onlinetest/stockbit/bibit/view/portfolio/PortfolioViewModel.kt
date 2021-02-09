package com.onlinetest.stockbit.bibit.view.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PortfolioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Halaman Portfolio"
    }
    val text: LiveData<String> = _text
}