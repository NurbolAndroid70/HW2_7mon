package com.example.myapplication.data.remote

import com.example.myapplication.domain.models.CamerasModel
import com.example.myapplication.domain.models.DoorsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameras():Response<CamerasModel>

    @GET("doors/")
    suspend fun getDoors():Response<DoorsModel>
}