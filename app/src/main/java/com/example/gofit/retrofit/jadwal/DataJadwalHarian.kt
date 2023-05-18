package com.example.gofit.retrofit.jadwal

import com.example.gofit.retrofit.login.ResponseLogin
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class DataJadwalHarian (
//    @SerializedName("id")
//    val id:String,
//
//    @SerializedName("tglJadwal")
//    val tglJadwal:String,
//
//    @SerializedName("hariJadwal")
//    val hariJadwal:String,
//
//    @SerializedName("sesiJadwal")
//    val sesiJadwal:Int,
//
//    @SerializedName("status")
//    val status:String,
//
//    @SerializedName("instruktur")
//    val instruktur: ResponseLogin.dataUser.dataInstruktur,
//
//    @SerializedName("instrukturPeganti")
//    val instrukturPeganti: ResponseLogin.dataUser.dataInstruktur,
//
//    @SerializedName("kelas")
//    val kelas: DataKelas,
//
//    )

 class DataJadwalHarian {
     @SerializedName("id")
     @Expose
     val id: String?=null

     @SerializedName("tglJadwal")
     @Expose
     val tglJadwal: String?=null

     @SerializedName("hariJadwal")
     @Expose
     val hariJadwal: String?=null

     @SerializedName("sesiJadwal")
     @Expose
     val sesiJadwal: Int?=null

     @SerializedName("status")
     @Expose
     val status: String?=null

     @SerializedName("instruktur")
     @Expose
     val instruktur: ResponseLogin.dataUser.dataInstruktur?=null

     @SerializedName("instrukturPeganti")
     @Expose
     val instrukturPeganti: ResponseLogin.dataUser.dataInstruktur?=null

     @SerializedName("kelas")
     @Expose
     val kelas: DataKelas?=null

     class DataKelas {
         @SerializedName("id")
         @Expose
         var id: String? = null

         @SerializedName("nama")
         @Expose
         var nama: String? = null

         @SerializedName("harga")
         @Expose
         var harga: String? = null

         @SerializedName("slot")
         @Expose
         var slot: String? = null

     }
 }