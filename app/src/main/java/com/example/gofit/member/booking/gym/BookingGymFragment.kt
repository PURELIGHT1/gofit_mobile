package com.example.gofit.member.jadwal.harian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gofit.databinding.FragmentBookingGymBinding
import com.example.gofit.retrofit.jadwal.DataJadwalUmum
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNREACHABLE_CODE")
class BookingGymFragment : Fragment() {

    private var _binding: FragmentBookingGymBinding? = null
    private val binding get() = _binding!!
    private val listJadwalUmum = ArrayList<DataJadwalUmum>()
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
        _binding = FragmentBookingGymBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getDataJadwalharian()
    }

//    private fun setUpRecycleView() {
//        rvJadwalHarian.apply {
//            binding.rvData.setHasFixedSize(true)
//            binding.rvData.layoutManager = LinearLayoutManager(context)
//            binding.rvData.adapter =jadwalHarianAdapter
//        }
//    }

//    private fun getDataJadwalharian() {
//        binding.rvData.setHasFixedSize(true)
//        binding.rvData.layoutManager = LinearLayoutManager(context)
//        binding.progressBar.visibility
//
//        val dateFormat: DateFormat = SimpleDateFormat("Y-MM-dd")
//        val date = Date()
//        val currentDateTime: String = dateFormat.format(date)
//
//        RClient.instances.getSlot(currentDateTime,1).enqueue(object :
//            Callback<ResponseSlot> {
//            override fun onResponse(
//                call: Call<ResponseSlot>,
//                response: Response<ResponseSlot>
//            ) {
////                if (response.isSuccessful){
////                    listJadwalUmum.clear()
////
////                    response.body()?.let { it.data?.let { it1 -> listJadwalUmum.addAll(it1) } }
////                    val adapter = jadwalKosongAdapter(listJadwalUmum, requireContext())
////                    binding.rvData.adapter = adapter
////                    adapter.notifyDataSetChanged()
////                    binding.progressBar.isVisible = false
////                }
//            }
//
//            override fun onFailure(call: Call<ResponseSlot>, t: Throwable) {
//            }
//
//        })
//    }
}