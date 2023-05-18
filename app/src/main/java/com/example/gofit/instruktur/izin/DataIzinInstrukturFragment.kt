package com.example.gofit.instruktur.izin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit.databinding.FragmentDataIzinInstrukturBinding
import com.example.gofit.retrofit.RClient
import com.example.gofit.retrofit.izin.DataIzinInstruktur
import com.example.gofit.retrofit.izin.ResponseDataIzinInstruktur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataIzinInstrukturFragment : Fragment() {
    private var _binding: FragmentDataIzinInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listIzin = ArrayList<DataIzinInstruktur>()
    var pref: SharedPreferences? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIzinInstrukturBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val id = pref!!.getString("user", "")
        id?.let { getDataIzin(it) }
    }
    private fun getDataIzin(id: String) {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)
        val bundle = arguments
        binding.progressBar.visibility
        RClient.instances.getIzinInstruktur(id).enqueue(object :Callback<ResponseDataIzinInstruktur> {
            override fun onResponse(
                call: Call<ResponseDataIzinInstruktur>,
                response: Response<ResponseDataIzinInstruktur>
            ) {
                if (response.isSuccessful){
                    listIzin.clear()

                    response.body()?.let {listIzin.addAll(it.data) }
                    val adapter = IzinInstrukturAdapter(listIzin, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseDataIzinInstruktur>, t: Throwable) {
            }

        })
    }
}