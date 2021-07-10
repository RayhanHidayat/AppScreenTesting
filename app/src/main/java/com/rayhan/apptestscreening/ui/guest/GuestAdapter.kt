package com.rayhan.apptestscreening.ui.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rayhan.apptestscreening.databinding.GuideItemBinding

class GuestAdapter(private val list: MutableList<GuideModel>) :
    RecyclerView.Adapter<GuestAdapter.ViewHolder>() {

    lateinit var listener: GuestRecyclerViewClickListener

    inner class ViewHolder(private val itemBinding: GuideItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: GuideModel) {
            with(itemBinding) {
                tvGuide.text = data.name

                Glide.with(itemView.context).load(data.image).into(imgGuide)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        GuideItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            listener.onItemClicked(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}