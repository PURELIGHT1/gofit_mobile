package com.example.gofit.retrofit.jadwal

import com.google.gson.annotations.SerializedName


data class ResponseDataJadwalHarian (
    @SerializedName("status") val stt:String,
    @SerializedName("data") val data:List<DataJadwalHarian>
)