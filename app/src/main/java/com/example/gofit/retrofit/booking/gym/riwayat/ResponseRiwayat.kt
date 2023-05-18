package com.example.gofit.retrofit.booking.gym.riwayat

import com.example.gofit.retrofit.booking.gym.DataBookingGym
import com.example.gofit.retrofit.izin.DataIzinInstruktur
import com.google.gson.annotations.SerializedName

data class ResponseRiwayat (
    @SerializedName("status") val stt:String,
    @SerializedName("data") val data:List<DataBookingGym>
)