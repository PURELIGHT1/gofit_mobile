package com.example.gofit.retrofit.kelas

import com.google.gson.annotations.SerializedName

data class ResponseDataKelas (
    @SerializedName("status") val stt:String,
    @SerializedName("data") val data:List<DataTabelKelas>
)