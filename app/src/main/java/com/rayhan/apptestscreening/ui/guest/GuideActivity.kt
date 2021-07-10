package com.rayhan.apptestscreening.ui.guest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rayhan.apptestscreening.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding
    private val guestViewModel by viewModels<GuestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Guest"

        guestViewModel.getGuideData()

        guestViewModel.guestData.observe(this, {
            renderAllData(it)
        })
    }

    private fun renderAllData(list: List<GuideModel>) {
        binding.run {
            rvEvent.layoutManager = GridLayoutManager(this@GuideActivity, 2)
            val adapter = GuestAdapter(list.toMutableList())
            rvEvent.adapter = adapter
        }
    }
}