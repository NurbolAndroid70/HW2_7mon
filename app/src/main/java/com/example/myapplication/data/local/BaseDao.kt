package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.local.models.CamerasEntity
import com.example.myapplication.data.local.models.DoorsEntity

@Dao
interface BaseDao {

    @Insert
    fun insertCamerasModel(model: CamerasEntity)

    @Insert
    fun insertDoorsModel(model: DoorsEntity)

    @Query("SELECT COUNT(*) FROM camera_model")
    fun getCamerasCount(): Int

    @Query("SELECT count(*) FROM doors_data")
    fun getDoorsCount(): Int
}