package com.example.gofit.mo.presensi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.gofit.R
import com.example.gofit.databinding.ActivityPresensiInstrukturBinding
import com.example.gofit.instruktur.MenuInstrukturActivity
import com.example.gofit.member.jadwal.harian.JadwalHarianKelasFagment
import com.example.gofit.mo.MenuMoActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PresensiInstrukturActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityPresensiInstrukturBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presensi_instruktur)

        binding = ActivityPresensiInstrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataPresensiInstrukturFragment()

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@PresensiInstrukturActivity, MenuMoActivity::class.java))
            finish()
        }

        binding.txtCari.setOnKeyListener(View.OnKeyListener{ _, keyCode, event->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action== KeyEvent.ACTION_UP)
            {
                showDataPresensiInstrukturFragmentCari()
                return@OnKeyListener true
            }
            false
        })
    }

    private fun showDataPresensiInstrukturFragmentCari() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = JadwalHarianKelasFagment()

        val textCari = binding.txtCari.text
        val mBundle = Bundle()
        mBundle.putString("cari", textCari.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }

    private fun showDataPresensiInstrukturFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = JadwalHarianKelasFagment()

        val mBundle = Bundle()
        mBundle.putString("cari", "cari")
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }
}