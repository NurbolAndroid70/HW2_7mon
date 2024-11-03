package com.example.myapplication.domain.models

data class CamerasModel(
    var id: Int? = null,
    var data: Data,
    val success: Boolean
) {
    data class Data(
        var cameras: List<Cameras>,
        val rooms: List<String>
    ) {
        data class Cameras(
            val favorites: Boolean,
            val id: Int,
            val name: String,
            val rec: Boolean,
            val room: String,
            val snapshot: String
        )
    }
}