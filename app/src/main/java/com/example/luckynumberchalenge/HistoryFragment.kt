package com.example.luckynumberchalenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HistoryFragment : Fragment() {
    private lateinit var rvHistory: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        rvHistory = view.findViewById(R.id.rvHistory)
        val historyList = createDummyHistory()
        val adapter = HistoryAdapter(historyList)
        rvHistory.adapter = adapter
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    fun createDummyHistory(): List<History> {
        return listOf(
            History(
                angka = 7,
                hukuman = "Push up 20 kali",
                tanggal = "15 Januari 2025, 15.30"
            ),
            History(
                angka = 3,
                hukuman = "Upload foto selfie terjelek",
                tanggal = "15 Januari 2025, 15.30"
            ),
            History(
                angka = 1,
                hukuman = "Traktir temen es krim",
                tanggal = "15 Januari 2025, 15.30"
            )
        )
    }
}