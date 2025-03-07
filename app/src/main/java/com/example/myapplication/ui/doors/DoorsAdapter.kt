package com.example.myapplication.ui.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemDoorsBinding
import com.example.myapplication.domain.models.DoorsModel

class DoorsAdapter : ListAdapter<DoorsModel.Data, DoorsAdapter.DoorsViewHolder>(
    DoorDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
        fun bind(item: DoorsModel.Data) = with(binding) {
            itemView.setOnClickListener {
                if (imgDoor.visibility == View.GONE) {
                    imgDoor.visibility =
                        View.VISIBLE; btnPlay.visibility = View.VISIBLE
                } else {
                    imgDoor.visibility = View.GONE
                    btnPlay.visibility = View.GONE
                }
            }
            tvNameDoor.text = item.name
            Glide.with(imgDoor).load(item.snapshot).into(imgDoor)
        }
    }

}

class DoorDiffCallback : DiffUtil.ItemCallback<DoorsModel.Data>() {
    override fun areItemsTheSame(oldItem: DoorsModel.Data, newItem: DoorsModel.Data) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DoorsModel.Data, newItem: DoorsModel.Data) =
        oldItem == newItem

}