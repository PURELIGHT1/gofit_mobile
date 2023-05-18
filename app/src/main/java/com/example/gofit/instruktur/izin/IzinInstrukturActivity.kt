package com.example.gofit.instruktur.izin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.gofit.R
import com.example.gofit.databinding.ActivityIzinInstrukturBinding
import com.example.gofit.databinding.ActivityLoginBinding
import com.example.gofit.instruktur.MenuInstrukturActivity

class IzinInstrukturActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIzinInstrukturBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_izin_instruktur)

        binding = ActivityIzinInstrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataFragment()

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@IzinInstrukturActivity, MenuInstrukturActivity::class.java))
            finish()
        }

        binding.btnAdd.setOnClickListener{
            startActivity(Intent(this@IzinInstrukturActivity, TambahIzinActivity::class.java))
            finish()
        }
    }

    private fun showDataFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataIzinInstrukturFragment()
        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }

}