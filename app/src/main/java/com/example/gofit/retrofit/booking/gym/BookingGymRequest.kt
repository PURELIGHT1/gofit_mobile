package com.example.gofit.retrofit.booking.gym

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

class BookingGymRequest {
    @SerializedName("tglBooking")
    @Expose
    var tglBooking: String? = null

    @SerializedName("sesi")
    @Expose
    var sesi: Int? = null
}
