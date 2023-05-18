package com.example.gofit.retrofit

import com.example.gofit.retrofit.jadwal.DataJadwalUmum
import com.google.gson.annotations.SerializedName

class ResponseDelete {
    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    val message:String? = null
}