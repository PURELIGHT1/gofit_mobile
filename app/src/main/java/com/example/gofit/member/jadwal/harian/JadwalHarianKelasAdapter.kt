package com.example.gofit.member.jadwal.harian

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit.databinding.ListKelasHariIniBinding
import com.example.gofit.retrofit.jadwal.DataJadwalHarian
import kotlin.collections.ArrayList

class JadwalHarianKelasAdapter (
    private val listJadwalKelas:ArrayList<DataJadwalHarian>,
    private val context: Context
): RecyclerView.Adapter<JadwalHarianKelasAdapter.JadwalHarianKelasViewHolder>() {
    inner class JadwalHarianKelasViewHolder(item: ListKelasHariIniBinding): RecyclerView.ViewHolder(item.root){

        private val binding = item
        fun bind(data: DataJadwalHarian){
            with(binding) {
                rvKelas.text = data.kelas?.nama
                rvTgl.text = data.tglJadwal
                rvHari.text = data.hariJadwal
                data.sesiJadwal?.let { rvSesi.text }
//                if(data.sesiJadwal?.let {  } .equals(1)){
//                    rvSesi.text = "08.00"
//                } else if (data.sesiJadwal.equals(2)){
//                    rvSesi.text = "09.30"
//                } else if (data.sesiJadwal.equals(3)){
//                    rvSesi.text = "17.00"
//                } else if (data.sesiJadwal.equals(4)){
//                    rvSesi.text = "18.30"
//                }
                rvIns.text = data.instruktur?.nama

                if(data.instrukturPeganti?.nama.equals("")){
                    rvInsPengganti.text = "-"
                } else {
                    rvInsPengganti.text = "Mengganti "+data.instrukturPeganti?.nama
                }

            }
        }

    }

//    interface OnAdapterListener {
//        fun onUpdate(data: DataJadwalUmum)
//        fun onDownload(data: DataJadwalUmum)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): JadwalHarianKelasAdapter.JadwalHarianKelasViewHolder {
        return JadwalHarianKelasViewHolder(
            ListKelasHariIniBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))
    }
    override fun onBindViewHolder(holder: JadwalHarianKelasAdapter.JadwalHarianKelasViewHolder,
                                  position: Int) {
        holder.bind(listJadwalKelas[position])
    }
    override fun getItemCount(): Int = listJadwalKelas.size
}