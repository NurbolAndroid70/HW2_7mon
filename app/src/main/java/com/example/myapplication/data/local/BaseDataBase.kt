package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.models.CamerasEntity
import com.example.myapplication.data.local.models.DoorsEntity

@Database(entities = [CamerasEntity::class, DoorsEntity::class], version = 2)
abstract class BaseDataBase : RoomDatabase() {
    abstract fun homeDao(): BaseDao
}