package com.example.luckynumberchalenge

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*

class GameFragment : Fragment(R.layout.fragment_game) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etJumlah = view.findViewById<EditText>(R.id.etJumlah)
        val btnGenerate = view.findViewById<Button>(R.id.btnGenerate)
        val btnRandom = view.findViewById<Button>(R.id.btnRandom)
        val container = view.findViewById<LinearLayout>(R.id.containerInput)

        btnGenerate.setOnClickListener {
            container.removeAllViews()

            val jumlah = etJumlah.text.toString().toIntOrNull() ?: 0

            for (i in 1..jumlah) {
                val editText = EditText(requireContext())
                editText.hint = "Input ke $i"
                container.addView(editText)
            }
        }

        btnRandom.setOnClickListener {
            val listData = mutableListOf<String>()

            for (i in 0 until container.childCount) {
                val et = container.getChildAt(i) as EditText
                if (et.text.isNotEmpty()) {
                    listData.add(et.text.toString())
                }
            }

            if (listData.isNotEmpty()) {
                val hasil = listData.random()

                val intent = Intent(requireContext(), ResultActivity::class.java)
                intent.putExtra("HASIL", hasil)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Isi dulu datanya!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
