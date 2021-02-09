package com.onlinetest.stockbit.bibit.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onlinetest.stockbit.bibit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}