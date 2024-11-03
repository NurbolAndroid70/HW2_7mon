package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repositories.DoorsRepository
import javax.inject.Inject

class GetDoorsUseCase @Inject constructor(private val doorsRepository: DoorsRepository) {
    suspend fun getDoors() = doorsRepository.getDoors()
}