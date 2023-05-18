package com.example.gofit.retrofit.booking.kelas

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BookingKelasRequest{
    @SerializedName("tglBooking")
    @Expose
    var tglBooking: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}