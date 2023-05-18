package com.example.gofit.member.booking.gym.riwayat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit.databinding.FragmentRiyawatBookingGymBinding
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.booking.gym.DataBookingGym
import com.example.gofit.retrofit.booking.gym.riwayat.ResponseRiwayat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class RiyawatBookingGymFragment : Fragment() {
    private var _binding: FragmentRiyawatBookingGymBinding? = null
    private val binding get() = _binding!!

    private var b:Bundle? = null
    private val listRiwayat = ArrayList<DataBookingGym>()
    var pref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRiyawatBookingGymBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        pref = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")
        id?.let { getDataRiwayat(it) }
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        pref = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
//        val id = pref!!.getString("user", "")
//
//        id?.let { getDataRiwayat(it) }
//
//    }

    private fun getDataRiwayat(id: String) {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        val bundle = arguments
        val cari = bundle?.getString("cari")
            RClient.instances.getRiwayatBook(id,cari).enqueue(object :
                Callback<ResponseRiwayat> {
                override fun onResponse(
                    call: Call<ResponseRiwayat>,
                    response: Response<ResponseRiwayat>
                ) {
                    if (response.isSuccessful){
                        listRiwayat.clear()

                        response.body()?.let { it.data?.let { it1 -> listRiwayat.addAll(it1) } }
                        val adapter = RiwayatBookingGymAdapter(listRiwayat, requireContext())
                        binding.rvData.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.progressBar.isVisible = false
                    }
                }

                override fun onFailure(call: Call<ResponseRiwayat>, t: Throwable) {
                }

            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}