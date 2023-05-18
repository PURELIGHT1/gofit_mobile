package com.example.gofit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.databinding.ActivityLoginBinding
import com.example.gofit.instruktur.MenuInstrukturActivity
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.mo.MenuMoActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.login.ResponseLogin
import com.example.gofit.retrofit.login.UserRequest
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()
    }

    private fun initAction() {
        btn_login.setOnClickListener{
            login()
        }
//        umum.setOnClickListener {
//            startActivity(Intent(this@LoginActivity, UmumActivity::class.java))
//            finish()
//        }
    }

    private fun login() {
        val username: String = binding.inputUsername.text.toString()
        val password: String = binding.inputPassword.text.toString()
        if(username.isEmpty()){
            binding.inputUsername.error = "Username tidak boleh kosong"
            return
        }
        if(password.isEmpty()){
            binding.inputPassword.error = "Password tidak boleh kosong"
            return
        }

        val request = UserRequest()
        request.username = username
        request.password = password

        RClient.instances.login(request).enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(
                call: Call<ResponseLogin>,
                response: Response<ResponseLogin>
            ) {
                if(response.isSuccessful){
                    val user = response.body()

                    val role =  user!!.data?.role?.toString()
                    val edit : SharedPreferences.Editor = pref!!.edit()
                    user!!.data?.id?.let { edit.putInt("id", it).commit() }
                    user!!.data?.role?.let { edit.putString("role", it).commit() }
                    edit.apply()

                    Toast.makeText(this@LoginActivity, "Login Berhasil", Toast.LENGTH_LONG).show()
                    if(role.equals("INSTRUKTUR")){
                        user!!.data?.instruktur?.id?.let { edit.putString("user", it).commit() }
                        startActivity(Intent(this@LoginActivity, MenuInstrukturActivity::class.java))
                        finish()
                    } else if(role.equals("MEMBER")){
                        user!!.data?.member?.id?.let { edit.putString("user", it).commit() }
                        startActivity(Intent(this@LoginActivity, MenuMemberActivity::class.java))
                        finish()
                    } else if(role.equals("MO")){
                        user!!.data?.pegawai?.id?.let { edit.putString("user", it).commit() }
                        startActivity(Intent(this@LoginActivity, MenuMoActivity::class.java))
                        finish()
                    }
                }else{
                    Toast.makeText(this@LoginActivity, "Login Gagal!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@LoginActivity, LoginActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}
