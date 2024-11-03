package com.example.myapplication.data.repositories

import com.example.myapplication.data.remote.ApiService
import com.example.myapplication.data.utils.Resource
import com.example.myapplication.data.utils.mapToCamerasModel
import com.example.myapplication.data.utils.mapToDoorsModel
import com.example.myapplication.domain.models.CamerasModel
import com.example.myapplication.domain.models.DoorsModel
import com.example.myapplication.domain.repositories.CamerasRepository
import com.example.myapplication.domain.repositories.DoorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val apiService: ApiService) : CamerasRepository, DoorsRepository {

    override suspend fun getCameras(): Flow<Resource<CamerasModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getCameras().body()!!.mapToCamerasModel()
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }
        }

    override suspend fun getDoors(): Flow<Resource<DoorsModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getDoors().body()!!.mapToDoorsModel()
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }
        }

}