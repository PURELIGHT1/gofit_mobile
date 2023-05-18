package com.example.gofit.member.booking.gym.riwayat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit.MainActivity
import com.example.gofit.databinding.ListItemBinding
import com.example.gofit.databinding.ListRiwayatBinding
import com.example.gofit.member.MenuMemberActivity
import com.example.gofit.retrofit.booking.gym.DataBookingGym

class RiwayatBookingGymAdapter(
    private val listRiyawat:ArrayList<DataBookingGym>,
    private val context: Context
) : RecyclerView.Adapter<RiwayatBookingGymAdapter.DataViewHolder>() {
    inner class DataViewHolder(item: ListRiwayatBinding): RecyclerView.ViewHolder(item.root){
        private val binding = item
        fun bind(data: DataBookingGym){
            with(binding) {
                rvTgl.text = data.tglBooking
                if(data.sesi.equals(1)){
                    rvSesi.text = "08.00"
                } else if (data.sesi.equals(2)){
                    rvSesi.text = "09.30"
                } else if (data.sesi.equals(3)){
                    rvSesi.text = "17.00"
                } else if (data.sesi.equals(4)){
                    rvSesi.text = "18.30"
                }

                cvData.setOnClickListener {
                    var i = Intent(context, BatalRiwayatBookingGymActivity::class.java).apply {
                        putExtra("idBooking",data.id)
                    }
                    context.startActivity(i)
                }
            }
        }

    }

//    interface OnAdapterListener {
//        fun onUpdate(data: DataJadwalUmum)
//        fun onDownload(data: DataJadwalUmum)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): RiwayatBookingGymAdapter.DataViewHolder {
        return DataViewHolder(
            ListRiwayatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))
    }

    override fun onBindViewHolder(holder: RiwayatBookingGymAdapter.DataViewHolder,
                                  position: Int) {
        holder.bind(listRiyawat[position])
    }
    override fun getItemCount(): Int = listRiyawat.size
}

