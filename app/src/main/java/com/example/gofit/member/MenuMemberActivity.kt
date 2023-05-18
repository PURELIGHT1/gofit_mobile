package com.example.gofit.member

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit.LoginActivity
import com.example.gofit.R
import com.example.gofit.databinding.ActivityMenuMemberBinding
import com.example.gofit.member.booking.gym.BookingGymActivity
import com.example.gofit.member.booking.kelas.BookingKelasActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MenuMemberActivity : AppCompatActivity() {
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityMenuMemberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_member)

        binding = ActivityMenuMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        setUpCardView()
    }

    private fun setUpCardView() {
        binding.btnPofile.setOnClickListener {
            startActivity(Intent(this@MenuMemberActivity, ProfileMemberActivity::class.java))
            finish()
        }
        binding.btnBookingKelas.setOnClickListener {
            startActivity(Intent(this@MenuMemberActivity, BookingKelasActivity::class.java))
            finish()
        }
        binding.btnBookingGym.setOnClickListener {
                startActivity(Intent(this@MenuMemberActivity, BookingGymActivity::class.java))
            finish()
        }
        binding.btnLogout.setOnClickListener {
            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this@MenuMemberActivity)
            materialAlertDialogBuilder.setTitle("Konfirmasi")
                .setMessage("Apakah anda yakin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Logout"){_,_ ->
                    val edit : SharedPreferences.Editor = pref!!.edit()
                    edit.clear()
                    edit.apply()
                    startActivity(Intent(this@MenuMemberActivity, LoginActivity::class.java))
                    finish()
                }.show()
        }
    }
}