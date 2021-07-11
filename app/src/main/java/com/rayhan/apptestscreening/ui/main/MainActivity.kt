package com.rayhan.apptestscreening.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.rayhan.apptestscreening.databinding.ActivityMainBinding
import com.rayhan.apptestscreening.ui.event.EventActivity
import com.rayhan.apptestscreening.ui.event.EventModel
import com.rayhan.apptestscreening.ui.guest.GuestActivity
import com.rayhan.apptestscreening.ui.guest.GuestModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = ""
    }

    private lateinit var binding: ActivityMainBinding
    private var dataEvent: EventModel? = null
    private var dataGuest: GuestModel? = null

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 111) {
                dataEvent = it.data?.getParcelableExtra("event")
                Log.e("activityResult", "data = $dataEvent")
            } else if (it.resultCode == 112) {
                dataGuest = it.data?.getParcelableExtra("guest")
                Log.e("activityResult", "data = $dataGuest")
            }
        }

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

    override fun onResume() {
        super.onResume()

        if (dataEvent != null) binding.btnEvent.text = dataEvent!!.nameEvent

        if (dataGuest != null) {
            binding.btnGuest.text = dataGuest!!.name


        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnEvent -> {
                val intent = Intent(this, EventActivity::class.java)
                activityResult.launch(intent)
            }
            binding.btnGuest -> {
                val intent = Intent(this, GuestActivity::class.java)
                activityResult.launch(intent)
            }
        }
    }
}