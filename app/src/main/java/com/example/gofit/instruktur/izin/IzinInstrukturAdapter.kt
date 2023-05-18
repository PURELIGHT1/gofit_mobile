package com.example.gofit.instruktur.izin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit.databinding.ListDataIzinBinding
import com.example.gofit.retrofit.izin.DataIzinInstruktur
class IzinInstrukturAdapter (
    private val listIzin:ArrayList<DataIzinInstruktur>,
    private val context: Context
):RecyclerView.Adapter<IzinInstrukturAdapter.MahasiswaViewHolder>() {
    inner class MahasiswaViewHolder(item:ListDataIzinBinding):RecyclerView.ViewHolder(item.root){
        private val binding = item
        fun bind(dataIzinInstruktur: DataIzinInstruktur){
            with(binding) {
                txtTgl.text = dataIzinInstruktur.tglpresensi
                if(dataIzinInstruktur.mulaiGym.equals("1")){
                    txtMulai.text = "08.00"
                } else if (dataIzinInstruktur.mulaiGym.equals("2")){
                    txtMulai.text = "09.30"
                } else if (dataIzinInstruktur.mulaiGym.equals("3")){
                    txtMulai.text = "17.00"
                } else if (dataIzinInstruktur.mulaiGym.equals("4")){
                    txtMulai.text = "18.30"
                }
//                txtMulai.text = dataIzinInstruktur.mulaiGym
                if(dataIzinInstruktur.akhirGym.equals("1")){
                    txtAkhir.text = "08.00"
                } else if (dataIzinInstruktur.akhirGym.equals("2")){
                    txtAkhir.text = "09.30"
                } else if (dataIzinInstruktur.akhirGym.equals("3")){
                    txtAkhir.text = "17.00"
                } else if (dataIzinInstruktur.akhirGym.equals("4")){
                    txtAkhir.text = "18.30"
                }

                if(dataIzinInstruktur.status.equals("PE")){
                    txtStatus.text = "Belum Konfirmasi Izin"
                } else if (dataIzinInstruktur.status.equals("C")){
                    txtStatus.text = "Sudah Konfirmasi Izin"
                }
//                txtAkhir.text = dataIzinInstruktur.akhirGym
//                txtStatus.text = dataIzinInstruktur.status
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): MahasiswaViewHolder {
        return MahasiswaViewHolder(ListDataIzinBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))
    }
    override fun onBindViewHolder(holder: MahasiswaViewHolder,
                                  position: Int) {
        holder.bind(listIzin[position])
    }
    override fun getItemCount(): Int = listIzin.size
}