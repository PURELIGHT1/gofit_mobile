package com.example.gofit.member.jadwal.harian

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit.R
import com.example.gofit.databinding.FragmentDataIzinInstrukturBinding
import com.example.gofit.databinding.FragmentJadwalHarianBinding
import com.example.gofit.instruktur.izin.IzinInstrukturAdapter
import com.example.gofit.instruktur.izin.JadwalHarianAdapter
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.izin.DataIzinInstruktur
import com.example.gofit.retrofit.izin.ResponseDataIzinInstruktur
import com.example.gofit.retrofit.jadwal.DataJadwalHarian
import com.example.gofit.retrofit.jadwal.DataJadwalUmum
import com.example.gofit.retrofit.jadwal.ResponseDataJadwalHarian
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.FileNotFoundException

@Suppress("UNREACHABLE_CODE")
class JadwalHarianFragment : Fragment() {

    private var _binding: FragmentJadwalHarianBinding? = null
    private val binding get() = _binding!!
    private val listJadwalUmum = ArrayList<DataJadwalHarian>()
//    lateinit var rvJadwalHarian: RecyclerView
//    var jadwalHarianAdapter: JadwalHarianAdapter = JadwalHarianAdapter(arrayListOf(), object: JadwalHarianAdapter.OnAdapterListener {
//        override fun onUpdate(data: DataJadwalUmum) {
//            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
//                    materialAlertDialogBuilder.setTitle("Konfirmasi")
//                        .setMessage("Apakah anda yakin booking kelas ini?")
//                        .setNegativeButton("Batal", null)
//                        .setPositiveButton("book!"){_,_ ->
//                        }.show()
//        }
//    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJadwalHarianBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataJadwalharian()
    }

//    private fun setUpRecycleView() {
//        rvJadwalHarian.apply {
//            binding.rvData.setHasFixedSize(true)
//            binding.rvData.layoutManager = LinearLayoutManager(context)
//            binding.rvData.adapter =jadwalHarianAdapter
//        }
//    }

    private fun getDataJadwalharian() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)
        val bundle = arguments
        binding.progressBar.visibility
        RClient.instances.getJadwalHarian().enqueue(object :
            Callback<ResponseDataJadwalHarian> {
            override fun onResponse(
                call: Call<ResponseDataJadwalHarian>,
                response: Response<ResponseDataJadwalHarian>
            ) {
                if (response.isSuccessful){
                    listJadwalUmum.clear()

                    response.body()?.let {listJadwalUmum.addAll(it.data) }
                    val adapter = JadwalHarianAdapter(listJadwalUmum, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseDataJadwalHarian>, t: Throwable) {
            }

        })
    }
}