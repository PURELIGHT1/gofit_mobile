package com.example.gofit.mo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.R
import com.example.gofit.databinding.ActivityProfileMemberBinding
import com.example.gofit.databinding.ActivityProfileMoBinding
import com.example.gofit.instruktur.MenuInstrukturActivity
import com.example.gofit.instruktur.UbahPasswordInstrukturActivity
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.profile.ResponseDataMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileMoActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityProfileMoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_mo)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")

        id?.let { getUserById(it) }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@ProfileMoActivity, MenuMoActivity::class.java))
            finish()
        }

        binding.btnUbahPass.setOnClickListener{
            startActivity(Intent(this@ProfileMoActivity, UbahPasswordMoActivity::class.java))
            finish()
        }
    }

    private fun getUserById(id: String) {
        RClient.instances.getPegawaiById(id).enqueue(object : Callback<ResponseDataMember> {
            override fun onResponse(
                call: Call<ResponseDataMember>,
                response: Response<ResponseDataMember>
            ) {
                if(response.isSuccessful){
                    val user = response.body()
                    Toast.makeText(this@ProfileMoActivity, "Berhasil mengambil data", Toast.LENGTH_LONG).show()
                    binding.NamaProfil.setText(user!!.data?.nama)
                    binding.AlamatProfil.setText(user!!.data?.alamat)
                    binding.TanggalLahirProfil.setText(user!!.data?.tglLahir)
                    binding.NomorTeleponProfil.setText(user!!.data?.noHp)
                    if(user!!.data?.status.equals("I")){
                        binding.Status.setText("Tidak Aktif")
                    } else if(user!!.data?.status.equals("A")){
                        binding.Status.setText("Aktif")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDataMember>, t: Throwable) {
                Toast.makeText(
                    this@ProfileMoActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}