package com.example.gofit.retrofit.izin

import com.google.gson.annotations.SerializedName

data class DataIzinInstruktur (
    @SerializedName("id")
    val id:String,

    @SerializedName("tglpresensi")
    val tglpresensi:String,

    @SerializedName("mulaiGym")
    val mulaiGym:String,

    @SerializedName("akhirGym")
    val akhirGym:String,

    @SerializedName("status")
    val status:String,
)