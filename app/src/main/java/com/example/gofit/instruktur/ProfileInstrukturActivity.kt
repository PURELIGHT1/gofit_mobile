package com.example.gofit.instruktur

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.R
import com.example.gofit.databinding.ActivityProfileInstrukturBinding
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.profile.ResponseDataInstruktur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileInstrukturActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityProfileInstrukturBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_instruktur)

        binding = ActivityProfileInstrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")

        id?.let { getUserById(it) }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@ProfileInstrukturActivity, MenuInstrukturActivity::class.java))
            finish()
        }

        binding.btnUbahPass.setOnClickListener{
            startActivity(Intent(this@ProfileInstrukturActivity, UbahPasswordInstrukturActivity::class.java))
            finish()
        }
    }

    private fun getUserById(id: String) {
        RClient.instances.getInstrukturById(id).enqueue(object : Callback<ResponseDataInstruktur> {
            override fun onResponse(
                call: Call<ResponseDataInstruktur>,
                response: Response<ResponseDataInstruktur>
            ) {
                if(response.isSuccessful){
                    val user = response.body()
                    Toast.makeText(this@ProfileInstrukturActivity, "Berhasil mengambil data", Toast.LENGTH_LONG).show()
                    binding.NamaProfil.setText(user!!.data?.nama)
                    binding.AlamatProfil.setText(user!!.data?.alamat)
                    binding.TanggalLahirProfil.setText(user!!.data?.tglLahir)
                    binding.NomorTeleponProfil.setText(user!!.data?.noHp)
                    binding.TotalHadirProfil.setText(user!!.data?.jlhHadir?.toString())
                    binding.TotalLiburProfil.setText(user!!.data?.jlhLibur?.toString())
                    binding.TotalTerlambatProfil.setText(user!!.data?.jlhTerlambat?.toString())
                }
            }

            override fun onFailure(call: Call<ResponseDataInstruktur>, t: Throwable) {
                Toast.makeText(
                    this@ProfileInstrukturActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}