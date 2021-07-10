package com.rayhan.apptestscreening.ui.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rayhan.apptestscreening.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}