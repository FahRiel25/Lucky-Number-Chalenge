package com.example.luckynumberchalenge

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*

class GameFragment : Fragment(R.layout.fragment_game) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etJumlah = view.findViewById<EditText>(R.id.etJumlah)
        val btnRandom = view.findViewById<Button>(R.id.btnRandom)
        val container = view.findViewById<LinearLayout>(R.id.containerInput)

        etJumlah.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                container.removeAllViews()

                val jumlah = s.toString().toIntOrNull() ?: 0
                if (jumlah <= 0) return

                for (i in 1..jumlah) {
                    val input = EditText(requireContext()).apply {
                        hint = "Hukuman ke $i"
                        background = requireContext().getDrawable(R.drawable.edittext_bg)
                        setPadding(32, 24, 32, 24)
                    }

                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 14, 0, 14)
                    input.layoutParams = params

                    container.addView(input)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        btnRandom.setOnClickListener {
            val listData = mutableListOf<String>()

            for (i in 0 until container.childCount) {
                val et = container.getChildAt(i) as EditText
                if (et.text.isNotEmpty()) listData.add(et.text.toString())
            }

            if (listData.isEmpty()) {
                Toast.makeText(requireContext(), "Isi dulu semua hukuman!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomIndex = (0 until listData.size).random()
            val intent = Intent(requireContext(), ResultActivity::class.java)
            intent.putExtra("ANGKA", randomIndex + 1)
            intent.putExtra("HUKUMAN", listData[randomIndex])
            startActivity(intent)
        }
    }
}
