package com.example.gofit.instruktur

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gofit.LoginActivity
import com.example.gofit.R
import com.example.gofit.databinding.ActivityMenuInstrukturBinding
import com.example.gofit.instruktur.izin.IzinInstrukturActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MenuInstrukturActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityMenuInstrukturBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_instruktur)

        binding = ActivityMenuInstrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        setUpCardView()
    }

    private fun setUpCardView() {
        binding.btnPofile.setOnClickListener {
            startActivity(Intent(this@MenuInstrukturActivity, ProfileInstrukturActivity::class.java))
            finish()
        }
        binding.btnIzin.setOnClickListener {
            startActivity(Intent(this@MenuInstrukturActivity, IzinInstrukturActivity::class.java))
            finish()
        }
        binding.btnPresensi.setOnClickListener {
            Toast.makeText(this@MenuInstrukturActivity, "PRESENSI", Toast.LENGTH_LONG).show()
        }
        binding.btnLogout.setOnClickListener {
            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this@MenuInstrukturActivity)
            materialAlertDialogBuilder.setTitle("Konfirmasi")
                .setMessage("Apakah anda yakin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Logout"){_,_ ->
                    val edit : SharedPreferences.Editor = pref!!.edit()
                    edit.clear()
                    edit.apply()
                    startActivity(Intent(this@MenuInstrukturActivity, LoginActivity::class.java))
                    finish()
                }.show()
        }
    }
}