package com.example.myapplication.domain.models

import com.google.gson.annotations.SerializedName

data class DoorsModel(
    val id: Int? = null,
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("favorites")
        val favorites: Boolean,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("rooms")
        val rooms: String,
        @SerializedName("snapshot")
        val snapshot: String
    )
}