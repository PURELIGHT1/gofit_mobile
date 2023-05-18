package com.example.gofit.instruktur.izin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit.databinding.ListDataJadwalHarianBinding
import com.example.gofit.member.booking.kelas.BookingKelasActivity
import com.example.gofit.retrofit.jadwal.DataJadwalHarian
import com.example.gofit.retrofit.jadwal.DataTabelJadwalHarian
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class JadwalHarianAdapter (
    private val listJadwalHarian:ArrayList<DataJadwalHarian>,
    private val context: Context
):RecyclerView.Adapter<JadwalHarianAdapter.JadwalHarianViewHolder>() {
    inner class JadwalHarianViewHolder(item:ListDataJadwalHarianBinding):RecyclerView.ViewHolder(item.root){

        var formatIncoming: SimpleDateFormat = SimpleDateFormat("d-M-Y")
        val tz: TimeZone = TimeZone.getTimeZone("Asia/Jakarta")
        private val binding = item
        fun bind(data: DataJadwalHarian){
            with(binding) {
                rvKelas.text = data.kelas?.nama
                rvHarga.text = data.kelas?.harga.toString()
                rvSlot.text = data.kelas?.slot.toString()
                rvInstruktur.text = data.instruktur?.nama
                rvTgl.text = data.tglJadwal
                rvHari.text = data.hariJadwal
                if(data.sesiJadwal?.equals(1)){
                    rvSesi.text = "08.00"
                } else if (data.sesiJadwal.equals(2)){
                    rvSesi.text = "09.30"
                } else if (data.sesiJadwal.equals(3)){
                    rvSesi.text = "17.00"
                } else if (data.sesiJadwal.equals(4)){
                    rvSesi.text = "18.30"
                }
                layBooking.setOnClickListener {
                    val materialAlertDialogBuilder = MaterialAlertDialogBuilder(context)
                    materialAlertDialogBuilder.setTitle("Konfirmasi")
                        .setMessage("Apakah anda yakin booking kelas ini?")
                        .setNegativeButton("Batal", null)
                        .setPositiveButton("book!"){_,_ ->
                            var i = Intent(context, BookingKelasActivity::class.java).apply {
                                putExtra("idBooking",data.id)
                            }

                            context.startActivity(i)
                        }.show()
                }
            }
        }

    }

//    interface OnAdapterListener {
//        fun onUpdate(data: DataJadwalUmum)
//        fun onDownload(data: DataJadwalUmum)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): JadwalHarianAdapter.JadwalHarianViewHolder {
        return JadwalHarianViewHolder(ListDataJadwalHarianBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))
    }
    override fun onBindViewHolder(holder: JadwalHarianAdapter.JadwalHarianViewHolder,
                                  position: Int) {
        holder.bind(listJadwalHarian[position])
    }
    override fun getItemCount(): Int = listJadwalHarian.size
}

