package com.example.gofit.member

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.R
import com.example.gofit.databinding.ActivityProfileMemberBinding
import com.example.gofit.instruktur.MenuInstrukturActivity
import com.example.gofit.instruktur.UbahPasswordInstrukturActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.profile.ResponseDataMember
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileMemberActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityProfileMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_member)

        binding = ActivityProfileMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")

        id?.let { getUserById(it) }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@ProfileMemberActivity, MenuMemberActivity::class.java))
            finish()
        }
    }

    private fun getUserById(id: String) {
        RClient.instances.getMemberById(id).enqueue(object : Callback<ResponseDataMember> {
            override fun onResponse(
                call: Call<ResponseDataMember>,
                response: Response<ResponseDataMember>
            ) {
                if(response.isSuccessful){
                    val user = response.body()
                    Toast.makeText(this@ProfileMemberActivity, "Berhasil mengambil data", Toast.LENGTH_LONG).show()
                    binding.NamaProfil.setText(user!!.data?.nama)
                    binding.AlamatProfil.setText(user!!.data?.alamat)
                    binding.TanggalLahirProfil.setText(user!!.data?.tglLahir)
                    binding.NomorTeleponProfil.setText(user!!.data?.noHp)
                    binding.TotalDepositProfil.setText(user!!.data?.sisaDeposit?.toString())
                    if(user!!.data?.status.equals("I")){
                        binding.StatusAktivasi.setText("Tidak Aktif")
                    } else if(user!!.data?.status.equals("A")){
                        binding.StatusAktivasi.setText("Aktif")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDataMember>, t: Throwable) {
                Toast.makeText(
                    this@ProfileMemberActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}