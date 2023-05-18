package com.example.gofit.member.booking.gym

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gofit.R
import com.example.gofit.databinding.ActivityBookingGymBinding
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.member.booking.gym.riwayat.RiwayatBookingGymActivity
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.booking.ResponseSlot
import com.example.gofit.retrofit.booking.gym.BookingGymRequest
import com.example.gofit.retrofit.booking.gym.ResponseBooking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class BookingGymActivity : AppCompatActivity() {
    companion object {
        private val _sesi = arrayOf("08.00", "09.30", "17.00", "18.30")
    }
    var pref: SharedPreferences? = null
    private lateinit var binding: ActivityBookingGymBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_kelas)

        binding = ActivityBookingGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setExposedDropdownMenu()
        pref = getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@BookingGymActivity, MenuMemberActivity::class.java))
            finish()
        }

        binding.tvTgl.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth ->
                binding.tglView.setText(dateToString(year,month,dayofMonth))
            }
            dateDialog(this@BookingGymActivity,datePicker).show()
        }

        binding.btnBook.setOnClickListener {
            id?.let { bookingGym(it) }
        }
        binding.btnRiwayat.setOnClickListener {
            startActivity(Intent(this@BookingGymActivity, RiwayatBookingGymActivity::class.java))
            finish()
        }
        setUpData1()
        setUpData2()
        setUpData3()
        setUpData4()
    }
    private fun setUpData1() {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        val date = Date()
        val sesi = 1
        val currentDateTime: String = dateFormat.format(date)
        RClient.instances.getSlot(currentDateTime,sesi).enqueue(object :
            Callback<ResponseSlot> {
            override fun onResponse(
                call: Call<ResponseSlot>,
                response: Response<ResponseSlot>
            ) {
                if (response.isSuccessful){
                   with(binding) {
                       shTgl.setText(currentDateTime)
                       shSlot.setText(response.body()?.data.toString())
                       if(sesi.equals(1)){
                           shSesi.setText("08.00")
                       } else if (sesi.equals(2)){
                           shSesi.setText("09.30")
                       } else if (sesi.equals(3)){
                           shSesi.setText("17.00")
                       } else if (sesi.equals(4)){
                           shSesi.setText("18.30")
                       }
                   }
                }
            }

            override fun onFailure(call: Call<ResponseSlot>, t: Throwable) {
            }

        })
    }

    private fun setUpData2() {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        val date = Date()
        val sesi = 2
        val currentDateTime: String = dateFormat.format(date)
        RClient.instances.getSlot(currentDateTime,sesi).enqueue(object :
            Callback<ResponseSlot> {
            override fun onResponse(
                call: Call<ResponseSlot>,
                response: Response<ResponseSlot>
            ) {
                if (response.isSuccessful){
                    with(binding) {
                        shSlot2.setText(response.body()?.data.toString())
                        if(sesi.equals(1)){
                            shSesi2.setText("08.00")
                        } else if (sesi.equals(2)){
                            shSesi2.setText("09.30")
                        } else if (sesi.equals(3)){
                            shSesi2.setText("17.00")
                        } else if (sesi.equals(4)){
                            shSesi2.setText("18.30")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseSlot>, t: Throwable) {
            }

        })
    }
    private fun setUpData3() {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        val date = Date()
        val sesi = 1
        val currentDateTime: String = dateFormat.format(date)
        RClient.instances.getSlot(currentDateTime,sesi).enqueue(object :
            Callback<ResponseSlot> {
            override fun onResponse(
                call: Call<ResponseSlot>,
                response: Response<ResponseSlot>
            ) {
                if (response.isSuccessful){
                    with(binding) {
                        shSlot3.setText(response.body()?.data.toString())
                        if(sesi.equals(1)){
                            shSesi3.setText("08.00")
                        } else if (sesi.equals(2)){
                            shSesi3.setText("09.30")
                        } else if (sesi.equals(3)){
                            shSesi3.setText("17.00")
                        } else if (sesi.equals(4)){
                            shSesi3.setText("18.30")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseSlot>, t: Throwable) {
            }

        })
    }
    private fun setUpData4() {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        val date = Date()
        val sesi = 1
        val currentDateTime: String = dateFormat.format(date)
        RClient.instances.getSlot(currentDateTime,sesi).enqueue(object :
            Callback<ResponseSlot> {
            override fun onResponse(
                call: Call<ResponseSlot>,
                response: Response<ResponseSlot>
            ) {
                if (response.isSuccessful){
                    with(binding) {
                        shSlot4.setText(response.body()?.data.toString())
                        if(sesi.equals(1)){
                            shSesi4.setText("08.00")
                        } else if (sesi.equals(2)){
                            shSesi4.setText("09.30")
                        } else if (sesi.equals(3)){
                            shSesi4.setText("17.00")
                        } else if (sesi.equals(4)){
                            shSesi4.setText("18.30")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseSlot>, t: Throwable) {
            }

        })
    }
    private fun dateToString(year: Int, month: Int, dayofMonth: Int): String {
        if(month<=9 && dayofMonth<=9){
            return year.toString()+"-0"+(month+1)+"-0"+dayofMonth.toString()
        }else if (month<=9 && dayofMonth>9){
            return year.toString()+"-0"+(month+1)+"-"+dayofMonth.toString()
        }else if (month>9 && dayofMonth<=9){
            return year.toString()+"-"+(month+1)+"-0"+dayofMonth.toString()
        } else {
            return year.toString()+"-"+(month+1)+"-"+dayofMonth.toString()
        }
    }

    private fun dateDialog(context: Context, datePicker:DatePickerDialog.OnDateSetListener):DatePickerDialog {
        val calender = Calendar.getInstance()
        return DatePickerDialog(
            context, datePicker,
            calender[Calendar.YEAR],
            calender[Calendar.MONTH],
            calender[Calendar.DAY_OF_MONTH],
        )
    }

    private fun bookingGym(id: String) {
        setExposedDropdownMenu()
        val sesi: String = binding.inputSesiBooking.text.toString()
        val tgl: String = binding.tglView.text.toString()
        val dateFormat: DateFormat = SimpleDateFormat("Y-MM-dd")
        val date = Date()
        val currentDateTime: String = dateFormat.format(date)
        if(sesi.isEmpty()){
            binding.inputSesiBooking.error = "Sesi Booking tidak boleh kosong"
            return
        }
        if(tgl.isEmpty()){
            binding.tglView.error = "Pilih lah tanggal dahulu"
            return
        } else if(tgl.compareTo(currentDateTime)<0){
            binding.tglView.error = "Tidak boleh kurang dari tanggal sekarang"
            return
        }

        val request = BookingGymRequest()
        request.tglBooking =  tgl
        if(sesi.equals("08.00")){
            request.sesi = 1
        } else if(sesi.equals("09.30")){
            request.sesi = 2
        } else if(sesi.equals("17.00")){
            request.sesi = 3
        } else if (sesi.equals("18.30")){
            request.sesi = 4
        }

        RClient.instances.addBookingGym(id, request).enqueue(object : Callback<ResponseBooking>{
            override fun onResponse(
                call: Call<ResponseBooking>,
                response: Response<ResponseBooking>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(
                        this@BookingGymActivity,
                        "Berhasil Booking Gym",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@BookingGymActivity, RiwayatBookingGymActivity::class.java))
                    finish()
                } else if(response.code() == 400) {
                    Toast.makeText(
                        this@BookingGymActivity,
                        "Cek Status Aktivasi Anda Terlebih Dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@BookingGymActivity, BookingGymActivity::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseBooking>, t: Throwable) {
                Toast.makeText(
                    this@BookingGymActivity,
                    t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

//    private fun showDataFragment() {
//        val mFragmentManager = supportFragmentManager
//        val mFragmentTransaction = mFragmentManager.beginTransaction()
//        val mFragment = BookingGymFragment()
//        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
//    }

    fun setExposedDropdownMenu(){
        val adapterJenis: ArrayAdapter<String> = ArrayAdapter<String>(this@BookingGymActivity, R.layout.item_list, _sesi)
        binding.inputSesiBooking.setAdapter(adapterJenis)
    }
}