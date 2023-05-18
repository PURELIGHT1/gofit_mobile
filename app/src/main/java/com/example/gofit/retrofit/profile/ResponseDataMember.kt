package com.example.gofit.retrofit.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseDataMember {
    @SerializedName("data")
    @Expose
    var data: dataMemberProfile? = null

    class dataMemberProfile {
        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("nama")
        @Expose
        var nama: String? = null

        @SerializedName("foto")
        @Expose
        var foto: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("alamat")
        @Expose
        var alamat: String? = null

        @SerializedName("tglLahir")
        @Expose
        var tglLahir: String? = null

        @SerializedName("noHp")
        @Expose
        var noHp: String? = null

        @SerializedName("sisaDeposit")
        @Expose
        var sisaDeposit: Int? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        @SerializedName("statusAktivasi")
        @Expose
        var statusAktivasi: String? = null
    }
}