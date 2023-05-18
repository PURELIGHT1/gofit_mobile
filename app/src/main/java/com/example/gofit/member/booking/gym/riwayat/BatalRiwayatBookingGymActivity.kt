package com.example.gofit.member.booking.gym.riwayat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gofit.R
import com.example.gofit.databinding.ActivityBatalRiwayatBookingGymBinding
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.ResponseDelete
import com.example.gofit.retrofit.booking.gym.riwayat.ResponseDataRiwayat
import com.example.gofit.retrofit.booking.gym.riwayat.ResponseRiwayat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatalRiwayatBookingGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBatalRiwayatBookingGymBinding
    private var b:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batal_riwayat_booking_gym)

        binding = ActivityBatalRiwayatBookingGymBinding.inflate(layoutInflater)
        setContentView(binding.root)


        b = intent.extras
        val id = b?.getString("idBooking")
        id?.let { getRiwayatById(it) }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@BatalRiwayatBookingGymActivity, RiwayatBookingGymActivity::class.java))
            finish()
        }

        binding.btnHapus.setOnClickListener {
            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this@BatalRiwayatBookingGymActivity)
            materialAlertDialogBuilder.setTitle("Konfirmasi")
                .setMessage("Apakah anda yakin batal booking ini?")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Ya"){_,_ ->
                    id?.let { batalBooking(it) }
                }.show()
        }
    }

    private fun batalBooking(id: String) {
        RClient.instances.deleteRiwayatById(id).enqueue(object : Callback<ResponseDelete> {
            override fun onResponse(
                call: Call<ResponseDelete>,
                response: Response<ResponseDelete>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(
                        this@BatalRiwayatBookingGymActivity,
                        "Berhasil Batal Booking Gym",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@BatalRiwayatBookingGymActivity, RiwayatBookingGymActivity::class.java))
                    finish()
                } else if(response.code() == 400){
                    Toast.makeText(this@BatalRiwayatBookingGymActivity, "Batal booking maksimal h-1 dari tanggal Booking", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseDelete>, t: Throwable) {
                Toast.makeText(
                    this@BatalRiwayatBookingGymActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    private fun getRiwayatById(id: String) {
        RClient.instances.getRiwayatById(id).enqueue(object : Callback<ResponseDataRiwayat> {
            override fun onResponse(
                call: Call<ResponseDataRiwayat>,
                response: Response<ResponseDataRiwayat>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    Toast.makeText(this@BatalRiwayatBookingGymActivity, "Berhasil mengambil data", Toast.LENGTH_LONG).show()
                    binding.tvTgl.setText(data!!.data?.tglBooking)
                    if(data!!.data?.sesi.toString().equals("1")){
                        binding.tvSesi.setText("08.00")
                    }else if(data!!.data?.sesi.toString().equals("2")){
                        binding.tvSesi.setText("09.30")
                    }else if(data!!.data?.sesi.toString().equals("3")){
                        binding.tvSesi.setText("17.00")
                    }else if(data!!.data?.sesi.toString().equals("4")){
                        binding.tvSesi.setText("18.30")
                    }
                    if(data!!.data?.status.equals("S")){
                        binding.tvStatus.setText("Terjadwal")
                    }else if(data!!.data?.status.equals("G")){
                        binding.tvStatus.setText("Sedang Berlangsung")
                    }else if(data!!.data?.status.equals("E")){
                        binding.tvStatus.setText("Berakhir")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDataRiwayat>, t: Throwable) {
                Toast.makeText(
                    this@BatalRiwayatBookingGymActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}