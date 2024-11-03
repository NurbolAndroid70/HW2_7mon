package com.example.myapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera_model")
data class CamerasEntity(
    @PrimaryKey
    var id: Int? = null,
    val count: Int
)