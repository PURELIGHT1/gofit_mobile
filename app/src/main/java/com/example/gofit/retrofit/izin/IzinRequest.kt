package com.example.gofit.retrofit.izin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IzinRequest {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("tglpresensi")
    @Expose
    var tglpresensi: String? = null

    @SerializedName("mulaiGym")
    @Expose
    var mulaiGym: Int? = null

    @SerializedName("akhirGym")
    @Expose
    var akhirGym: Int? = null
}