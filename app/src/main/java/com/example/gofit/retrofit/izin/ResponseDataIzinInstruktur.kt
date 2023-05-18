package com.example.gofit.retrofit.izin

import com.google.gson.annotations.SerializedName

data class ResponseDataIzinInstruktur (
    @SerializedName("status") val stt:String,
    @SerializedName("data") val data:List<DataIzinInstruktur>
)