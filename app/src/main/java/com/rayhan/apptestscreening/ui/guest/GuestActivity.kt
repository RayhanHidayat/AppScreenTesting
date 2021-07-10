package com.rayhan.apptestscreening.ui.guest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rayhan.apptestscreening.databinding.ActivityGuideBinding

class GuestActivity : AppCompatActivity(), GuestRecyclerViewClickListener {

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

    private fun renderAllData(list: List<GuestModel>) {
        binding.run {
            rvEvent.layoutManager = GridLayoutManager(this@GuestActivity, 2)
            val adapter = GuestAdapter(list.toMutableList())
            rvEvent.adapter = adapter
            adapter.listener = this@GuestActivity
        }
    }

    override fun onItemClicked(data: GuestModel) {

    }
}