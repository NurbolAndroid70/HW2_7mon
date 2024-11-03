package com.example.myapplication.data.utils

import com.example.myapplication.domain.models.CamerasModel
import com.example.myapplication.domain.models.DoorsModel

fun CamerasModel.mapToCamerasModel() =
    CamerasModel(
        id = id,
        data = data,
        success = success
    )

fun DoorsModel.mapToDoorsModel() =
    DoorsModel(
        id = id,
        data = data,
        success = success
    )