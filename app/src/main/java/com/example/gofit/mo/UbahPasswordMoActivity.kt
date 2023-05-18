package com.example.gofit.mo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.R
import com.example.gofit.databinding.ActivityUbahPasswordInstrukturBinding
import com.example.gofit.databinding.ActivityUbahPasswordMoBinding
import com.example.gofit.instruktur.ProfileInstrukturActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.ResponseUpdate
import com.example.gofit.retrofit.profile.PasswordRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UbahPasswordMoActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityUbahPasswordMoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_password_mo)

        binding = ActivityUbahPasswordMoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this@UbahPasswordMoActivity, ProfileMoActivity::class.java))
            finish()
        }

        binding.btnSave.setOnClickListener {
            id?.let { ubahPass(it) }
        }
    }

    private fun ubahPass(id: String) {
        val lama: String = binding.inputPasswordLama.text.toString()
        val baru: String = binding.inputPasswordBaru.text.toString()
        val konfirm: String = binding.inputKonfirmasiPasswordBaru.text.toString()

        if(lama.isEmpty()){
            binding.inputPasswordLama.error = "Username tidak boleh kosong"
            return
        }
        if(baru.isEmpty()){
            binding.inputPasswordBaru.error = "Password tidak boleh kosong"
            return
        }
        if(konfirm.isEmpty()){
            binding.inputPasswordBaru.error = "Password tidak boleh kosong"
            return
        }
        if(!baru.equals(konfirm)){
            Toast.makeText(this@UbahPasswordMoActivity, "Konfirmasi password salah", Toast.LENGTH_LONG).show()
        }
        if(baru.equals(lama)){
            Toast.makeText(this@UbahPasswordMoActivity, "Password baru tidak boleh sama dengan password lama", Toast.LENGTH_LONG).show()
        }

        val request = PasswordRequest()
        request.passwordBaru = baru

        RClient.instances.updatePasswordMo(id,request).enqueue(object :
            Callback<ResponseUpdate> {
            override fun onResponse(call: Call<ResponseUpdate>, response: Response<ResponseUpdate>) {
                if(response.isSuccessful){
                    val ins = response.body()
                    Toast.makeText(this@UbahPasswordMoActivity, ins!!.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@UbahPasswordMoActivity, ProfileInstrukturActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseUpdate>, t: Throwable) {
                Toast.makeText(
                    this@UbahPasswordMoActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}