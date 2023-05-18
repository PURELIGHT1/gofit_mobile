package com.example.gofit.retrofit.booking.gym

import com.example.gofit.retrofit.jadwal.DataJadwalUmum
import com.google.gson.annotations.SerializedName

class ResponseBooking  {
    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    val message:String? = null
//
//    @SerializedName("data")
//    val data:List<DataBookingGym>?= null
}