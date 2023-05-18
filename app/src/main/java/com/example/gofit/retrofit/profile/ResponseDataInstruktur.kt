package com.example.gofit.retrofit.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseDataInstruktur {
    @SerializedName("data")
    @Expose
    var data: dataInstrukturProfile? = null

    class dataInstrukturProfile {
        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("nama")
        @Expose
        var nama: String? = null

        @SerializedName("foto")
        @Expose
        var foto: String? = null

        @SerializedName("inisial")
        @Expose
        var inisial: String? = null

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

        @SerializedName("jlhHadir")
        @Expose
        var jlhHadir: Int? = null

        @SerializedName("jlhLibur")
        @Expose
        var jlhLibur: Int? = null

        @SerializedName("jlhTerlambat")
        @Expose
        var jlhTerlambat: Int? = null

        @SerializedName("status")
        @Expose
        var status: String? = null
    }
}