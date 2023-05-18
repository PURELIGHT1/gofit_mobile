package com.example.gofit.retrofit.jadwal

import com.example.gofit.retrofit.login.ResponseLogin
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataTabelJadwalHarian (
    @SerializedName("id")
    val id:Int,

    @SerializedName("tglJadwal")
    val tglJadwal:String,

    @SerializedName("hariJadwal")
    val hariJadwal:String,

    @SerializedName("sesiJadwal")
    val sesiJadwal:Int,

    @SerializedName("status")
    val status:String,

//    @SerializedName("kelas")
//    val kelas: dataKelas,
//
//    @SerializedName("instruktur")
//    val instruktur: ResponseLogin.dataUser.dataInstruktur,
//
//    @SerializedName("instrukturPeganti")
//    val instrukturPeganti: ResponseLogin.dataUser.dataInstruktur,
)
