package com.rayhan.apptestscreening.ui.event

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rayhan.apptestscreening.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity(), EventRecyclerViewClickListener {

    private lateinit var binding: ActivityEventBinding
    private lateinit var list: MutableList<EventModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Event"

        list = EventDataList.generateEventData()

        renderAllData(list)
    }

    private fun renderAllData(list: MutableList<EventModel>) {
        binding.run {
            rvEvent.setHasFixedSize(true)
            rvEvent.layoutManager = LinearLayoutManager(this@EventActivity)
            val adapter = EventAdapter(list)
            rvEvent.adapter = adapter
            adapter.listener = this@EventActivity
        }
    }

    override fun onItemClicked(data: EventModel) {
        val intent = Intent().putExtra("event", data)
        setResult(111, intent)
        finish()
    }
}