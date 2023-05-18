package com.example.gofit.retrofit.booking.gym.riwayat

import com.example.gofit.retrofit.jadwal.DataKelas
import com.example.gofit.retrofit.login.ResponseLogin
import com.google.gson.annotations.SerializedName

data class DataRiwayat (
    @SerializedName("id")
    val id:String,

    @SerializedName("tglBooking")
    val tglBooking:String,

    @SerializedName("hariJadwal")
    val hariJadwal:String,

    @SerializedName("sesiJadwal")
    val sesiJadwal:Int,

    @SerializedName("status")
    val status:String,

    @SerializedName("instruktur")
    val instruktur: ResponseLogin.dataUser.dataInstruktur,

    @SerializedName("instrukturPeganti")
    val instrukturPeganti: ResponseLogin.dataUser.dataInstruktur,

    @SerializedName("kelas")
    val kelas: DataKelas,

    )