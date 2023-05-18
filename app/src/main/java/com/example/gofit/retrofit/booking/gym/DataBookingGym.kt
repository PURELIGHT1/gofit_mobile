package com.example.gofit.retrofit.booking.gym

import com.example.gofit.retrofit.jadwal.DataKelas
import com.example.gofit.retrofit.jadwal.DataMember
import com.example.gofit.retrofit.login.ResponseLogin
import com.google.gson.annotations.SerializedName

data class DataBookingGym  (
    @SerializedName("id")
    val id:String,

    @SerializedName("tglBooking")
    val tglBooking:String,

    @SerializedName("tglBuat")
    val tglBuat:String,

    @SerializedName("sesi")
    val sesi:Int,

    @SerializedName("status")
    val status:String,
)