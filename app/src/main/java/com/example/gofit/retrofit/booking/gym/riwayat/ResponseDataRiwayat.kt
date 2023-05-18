package com.example.gofit.retrofit.booking.gym.riwayat

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseDataRiwayat {
    @SerializedName("data")
    @Expose
    var data: dataRiwayat? = null

    class dataRiwayat {
        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("tglBooking")
        @Expose
        var tglBooking: String? = null

        @SerializedName("tglBuat")
        @Expose
        var tglBuat: String? = null

        @SerializedName("sesi")
        @Expose
        var sesi: Int? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        @SerializedName("member")
        @Expose
        var member: dataMember? = null

        class dataMember {
            @SerializedName("id")
            @Expose
            var id: String? = null

            @SerializedName("nama")
            @Expose
            var nama: String? = null
        }
    }
}