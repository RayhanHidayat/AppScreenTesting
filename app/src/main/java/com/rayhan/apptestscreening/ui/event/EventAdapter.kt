package com.rayhan.apptestscreening.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rayhan.apptestscreening.databinding.EventItemBinding

class EventAdapter(private val list: MutableList<EventModel>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    lateinit var listener: EventRecyclerViewClickListener

    inner class ViewHolder(private val eventItemBinding: EventItemBinding) :
        RecyclerView.ViewHolder(eventItemBinding.root) {

        fun bind(data: EventModel) {
            with(eventItemBinding) {
                tvEvent.text = data.nameEvent
                tvDateEvent.text = data.date

                Glide.with(itemView.context).load(data.image).into(imgEvent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        EventItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            listener.onItemClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}