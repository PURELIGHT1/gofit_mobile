package com.example.gofit.retrofit

import com.example.gofit.retrofit.jadwal.DataJadwalHarian
import com.google.gson.annotations.SerializedName

class ResponseUpdate {
    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    val message:String? = null

    @SerializedName("data")
    val data:List<DataJadwalHarian>?= null
}