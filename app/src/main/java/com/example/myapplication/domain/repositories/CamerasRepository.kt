package com.example.myapplication.domain.repositories

import com.example.myapplication.data.utils.Resource
import com.example.myapplication.domain.models.CamerasModel
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {
    suspend fun getCameras(): Flow<Resource<CamerasModel>>
}