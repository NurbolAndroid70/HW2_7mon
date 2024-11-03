package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(private val camerasRepository: CamerasRepository) {
    suspend fun getCameras() = camerasRepository.getCameras()
}