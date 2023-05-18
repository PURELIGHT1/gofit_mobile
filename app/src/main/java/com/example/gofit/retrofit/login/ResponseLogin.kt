package com.example.gofit.retrofit.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseLogin {
    @SerializedName("data")
    @Expose
    var data: dataUser? = null

    class dataUser {
        @SerializedName("role")
        @Expose
        var role: String? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("pegawai")
        @Expose
        var pegawai: dataPegawai? = null

        class dataPegawai {
            @SerializedName("id")
            @Expose
            var id: String? = null
        }

        @SerializedName("instruktur")
        @Expose
        var instruktur: dataInstruktur? = null

        class dataInstruktur {
            @SerializedName("id")
            @Expose
            var id: String? = null

            @SerializedName("nama")
            @Expose
            var nama: String? = null
        }

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
