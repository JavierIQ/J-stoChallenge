package com.javieriq.justochallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javieriq.justochallenge.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var bingin: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingin = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(bingin.root)

        
    }
}