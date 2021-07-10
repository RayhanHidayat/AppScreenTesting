package com.rayhan.apptestscreening.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rayhan.apptestscreening.databinding.ActivityMainBinding
import com.rayhan.apptestscreening.ui.event.EventActivity
import com.rayhan.apptestscreening.ui.guest.GuestActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = ""
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra(EXTRA_NAME)

        if (name.contentEquals("")) name = "Default"

        binding.tvNamaDimasukkan.text = name
        binding.btnEvent.setOnClickListener(this)
        binding.btnGuest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnEvent -> {
                val intent = Intent(this, EventActivity::class.java)
                startActivity(intent)
            }
            binding.btnGuest -> {
                val intent = Intent(this, GuestActivity::class.java)
                startActivity(intent)
            }
        }
    }
}