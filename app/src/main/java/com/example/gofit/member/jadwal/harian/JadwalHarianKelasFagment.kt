package com.example.gofit.member.jadwal.harian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit.R
import com.example.gofit.databinding.FragmentBookingGymBinding
import com.example.gofit.databinding.FragmentJadwalHarianKelasFagmentBinding
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.ResponseUpdate
import com.example.gofit.retrofit.jadwal.DataJadwalHarian
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNREACHABLE_CODE")
class JadwalHarianKelasFagment : Fragment() {
    private var _binding: FragmentJadwalHarianKelasFagmentBinding? = null
    private val binding get() = _binding!!

    private var b:Bundle? = null
    private val listJadwalKelas = ArrayList<DataJadwalHarian>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJadwalHarianKelasFagmentBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataJadwalKelas()
    }

    private fun getDataJadwalKelas() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)
        binding.progressBar.visibility

//        val dateFormat: DateFormat = SimpleDateFormat("Y-MM-dd")
//        val date = Date()
//        val currentDateTime: String = dateFormat.format(date)
        val bundle = arguments
        val cari = bundle?.getString("cari")

        RClient.instances.getJadwalHarianByDate(cari).enqueue(object :
            Callback<ResponseUpdate> {
            override fun onResponse(
                call: Call<ResponseUpdate>,
                response: Response<ResponseUpdate>
            ) {
                if (response.isSuccessful){
                    listJadwalKelas.clear()

                    response.body()?.let { it.data?.let { it1 -> listJadwalKelas.addAll(it1) } }
                    val adapter = JadwalHarianKelasAdapter(listJadwalKelas, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseUpdate>, t: Throwable) {
            }

        })
    }
}