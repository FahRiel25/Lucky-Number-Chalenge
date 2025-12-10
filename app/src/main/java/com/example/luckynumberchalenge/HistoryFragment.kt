package com.example.luckynumberchalenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_history, container, false)
        val rvHistory = view.findViewById<RecyclerView>(R.id.rvHistory)
        val historyList = getHistory()
        val adapter = HistoryAdapter(historyList)
        rvHistory.adapter = adapter
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    fun getHistory(): List<History> {
        val data = mutableListOf<History>()
        data.add(
            History(
                angka = 7,
                hukuman = "Push up 20 kali",
                tanggal = "15 Januari 2025, 15.30"
            )
        )

        data.add(
            History(
                angka = 3,
                hukuman = "Upload foto selfie terjelek",
                tanggal = "13 Januari 2025, 09.30"
            )
        )

        data.add(
            History(
                angka = 1,
                hukuman = "Traktir temen es krim",
                tanggal = "15 Januari 2025, 14.30"
            )
        )

        data.add(
            History(
                angka = 2,
                hukuman = "Makan cabai",
                tanggal = "24 Januari 2025, 18.30"
            )
        )

        data.add(
            History(
                angka = 3,
                hukuman = "Traktir gacoan",
                tanggal = "22 Februari 2025, 15.30"
            )
        )
        return data
    }
}