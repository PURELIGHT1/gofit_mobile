package com.example.gofit.member.booking.gym.riwayat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.gofit.R
import com.example.gofit.databinding.ActivityRiwayatBookingGymBinding
import com.example.gofit.member.booking.gym.riwayat.RiyawatBookingGymFragment
import com.example.gofit.member.booking.gym.BookingGymActivity

class RiwayatBookingGymActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityRiwayatBookingGymBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_booking_gym)

        binding = ActivityRiwayatBookingGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataRiwayatBookFragment()

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@RiwayatBookingGymActivity, BookingGymActivity::class.java))
            finish()
        }
        binding.txtCari.setOnKeyListener(View.OnKeyListener{ _,keyCode, event->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action== KeyEvent.ACTION_UP)
            {
                showDataRiwayatBookFragmentCari()
                return@OnKeyListener true
            }
            false
        })
    }

    private fun showDataRiwayatBookFragmentCari() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = RiyawatBookingGymFragment()

        val textCari = binding.txtCari.text
        val mBundle = Bundle()
        mBundle.putString("cari", textCari.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }

    private fun showDataRiwayatBookFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = RiyawatBookingGymFragment()

        val mBundle = Bundle()
        mBundle.putString("cari", "cari")
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }
}