package com.example.gofit.mo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit.LoginActivity
import com.example.gofit.R
import com.example.gofit.databinding.ActivityMenuMoBinding
import com.example.gofit.mo.presensi.PresensiInstrukturActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MenuMoActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityMenuMoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_mo)

        binding = ActivityMenuMoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        setUpCardView()
    }

    private fun setUpCardView() {
        binding.btnPofile.setOnClickListener {
            startActivity(Intent(this@MenuMoActivity, ProfileMoActivity::class.java))
            finish()
        }
        binding.btnPresensiInstruktur.setOnClickListener {
            startActivity(Intent(this@MenuMoActivity, PresensiInstrukturActivity::class.java))
            finish()
        }
        binding.btnLogout.setOnClickListener {
            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this@MenuMoActivity)
            materialAlertDialogBuilder.setTitle("Konfirmasi")
                .setMessage("Apakah anda yakin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Logout"){_,_ ->
                    val edit : SharedPreferences.Editor = pref!!.edit()
                    edit.clear()
                    edit.apply()
                    startActivity(Intent(this@MenuMoActivity, LoginActivity::class.java))
                    finish()
                }.show()
        }
    }
}