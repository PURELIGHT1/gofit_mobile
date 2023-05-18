package com.example.gofit.instruktur.izin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.gofit.LoginActivity
import com.example.gofit.R
import com.example.gofit.databinding.ActivityTambahIzinBinding
import com.example.gofit.instruktur.MenuInstrukturActivity
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.izin.IzinRequest
import com.example.gofit.retrofit.izin.ResponseCreateIzin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahIzinActivity : AppCompatActivity() {
    companion object {
        private val _sesi = arrayOf("08.00", "09.30", "17.00", "18.30")
    }
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityTambahIzinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_izin)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        binding = ActivityTambahIzinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setExposedDropdownMenu()

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this@TambahIzinActivity, IzinInstrukturActivity::class.java))
            finish()
        }

        binding.btnSave.setOnClickListener {
            tambahIzin()
        }
    }

    fun setExposedDropdownMenu(){
        val adapterJenis: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.item_list, _sesi)
        binding.inputMulaiIzin.setAdapter(adapterJenis)
        binding.inputSelesaiIzin.setAdapter(adapterJenis)
    }

    private fun tambahIzin() {
        setExposedDropdownMenu()
        val tgl: String = binding.inputTglPresensi.text.toString()
        val mulai: String = binding.inputMulaiIzin.text.toString()
        val selesai: String = binding.inputSelesaiIzin.text.toString()
        if(tgl.isEmpty()) {
            binding.inputTglPresensi.error = "Tanggal Presensi tidak boleh kosong"
            return
        }
        if(mulai>selesai){
            binding.inputMulaiIzin.error = "Mulai Izin tidak boleh lebih besar dari Selesai Izin"
            binding.inputSelesaiIzin.error = "Selesai Izin tidak boleh lebih kecil dari Mulai Izin"
            return
        }
        val id = pref!!.getString("user", "")

        val request = IzinRequest()
        request.tglpresensi = tgl
        if(mulai.equals("08.00")){
            request.mulaiGym = 1
        } else if(mulai.equals("09.30")){
            request.mulaiGym = 2
        } else if(mulai.equals("17.00")){
            request.mulaiGym = 3
        } else if (mulai.equals("18.30")){
            request.mulaiGym = 4
        }

        if(selesai.equals("08.00")){
            request.akhirGym = 1
        } else if(selesai.equals("09.30")){
            request.akhirGym = 2
        } else if(selesai.equals("17.00")){
            request.akhirGym = 3
        } else if (selesai.equals("18.30")){
            request.akhirGym = 4
        }

        request.id = id

        RClient.instances.addIzin(request).enqueue(object : Callback<ResponseCreateIzin>{
            override fun onResponse(
                call: Call<ResponseCreateIzin>,
                response: Response<ResponseCreateIzin>
            ) {
                if(response.isSuccessful){
                    val user = response.body()
                    Toast.makeText(this@TambahIzinActivity, "Tambah Izin Berhasil", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@TambahIzinActivity, IzinInstrukturActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this@TambahIzinActivity, "Tambah Izin Gagal!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@TambahIzinActivity, TambahIzinActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseCreateIzin>, t: Throwable) {
            }

        })
    }

}