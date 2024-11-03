package com.example.myapplication.ui.cameras

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.databinding.ItemCamerasBinding
import com.example.myapplication.domain.models.CamerasModel


class CameraAdapter : ListAdapter<CamerasModel.Data.Cameras, CameraViewHolder>(
    CameraDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CameraViewHolder {
        return CameraViewHolder(
            ItemCamerasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CameraViewHolder(private val binding: ItemCamerasBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: CamerasModel.Data.Cameras) = with(binding) {
        tvCamera.text = position.name
        tvRoomName.text = position.room
        imgRoom.load(position.snapshot)
    }
}

class CameraDiffCallback : DiffUtil.ItemCallback<CamerasModel.Data.Cameras>() {
    override fun areContentsTheSame(
        oldItem: CamerasModel.Data.Cameras,
        newItem: CamerasModel.Data.Cameras
    ) = oldItem.id == newItem.id

    override fun areItemsTheSame(
        oldItem: CamerasModel.Data.Cameras,
        newItem: CamerasModel.Data.Cameras
    ) = oldItem == newItem
}