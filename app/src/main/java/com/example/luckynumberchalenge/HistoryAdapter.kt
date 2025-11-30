package com.example.luckynumberchalenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter (val historyData: List<History>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): HistoryViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)

        return HistoryViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: HistoryViewHolder, position: Int,
    ) {
        val history: History = historyData[position]
        holder.textViewCircle.text = history.angka.toString()
        holder.textViewAngka.text = "Angka: ${history.angka}"
        holder.textViewHukuman.text = "Hukuman: ${history.hukuman}"
        holder.textViewTanggal.text = history.tanggal
        holder.iconTime.setImageResource(R.drawable.icon_history)
    }

    override fun getItemCount(): Int = historyData.size
    class HistoryViewHolder(row: View): RecyclerView.ViewHolder(row){
        val textViewCircle: TextView = row.findViewById<TextView>(R.id.textViewCircle)
        val textViewAngka: TextView = row.findViewById<TextView>(R.id.textViewAngka)
        val textViewHukuman: TextView = row.findViewById<TextView>(R.id.textViewHukuman)
        val iconTime: ImageView = row.findViewById<ImageView>(R.id.icon_Time)
        val textViewTanggal: TextView = row.findViewById<TextView>(R.id.textViewTanggal)
    }
}

