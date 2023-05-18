package com.example.gofit.retrofit.jadwal

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataKelas (
    @SerializedName("id")
    val id: Int,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("harga")
    val harga: Int,

    @SerializedName("slot")
    val slot: Int,
)

//class DataKelas {
//    @SerializedName("id")
//    val id: Int? = null
//
//    @SerializedName("nama")
//    val nama: String? = null
//
//    @SerializedName("harga")
//    val harga: Int? = null
//
//    @SerializedName("slot")
//    val slot: Int? = null
//}