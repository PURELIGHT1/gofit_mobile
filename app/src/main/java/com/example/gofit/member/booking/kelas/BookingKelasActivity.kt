package com.example.gofit.member.booking.kelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit.R
import com.example.gofit.databinding.ActivityBookingKelasBinding
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.member.jadwal.harian.JadwalHarianFragment

class BookingKelasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingKelasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_gym)

        binding = ActivityBookingKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataFragment()

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@BookingKelasActivity, MenuMemberActivity::class.java))
            finish()
        }
    }

    private fun showDataFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = JadwalHarianFragment()
        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }
}