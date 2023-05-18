package com.example.gofit.retrofit.jadwal

import com.google.gson.annotations.SerializedName

data class DataMember (
    @SerializedName("id")
    val id: Int,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("foto")
    val foto: String,

    @SerializedName("sisaDeposit")
    val sisaDeposit: Int,
)