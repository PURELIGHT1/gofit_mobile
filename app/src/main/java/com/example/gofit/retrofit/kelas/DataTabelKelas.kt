package com.example.gofit.retrofit.kelas

import com.google.gson.annotations.SerializedName

data class DataTabelKelas (
    @SerializedName("id")
    val id:Int,

    @SerializedName("nama")
    val nama:String,

    @SerializedName("harga")
    val harga:Int,

    @SerializedName("slot")
    val slot:Int,
)