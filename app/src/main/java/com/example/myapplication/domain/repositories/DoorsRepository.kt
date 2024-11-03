package com.example.myapplication.domain.repositories

import com.example.myapplication.data.utils.Resource
import com.example.myapplication.domain.models.DoorsModel
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {
    suspend fun getDoors(): Flow<Resource<DoorsModel>>
}