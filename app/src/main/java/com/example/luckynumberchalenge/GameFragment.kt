package com.example.luckynumberchalenge

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import android.graphics.Color
import android.view.Gravity

class GameFragment : Fragment(R.layout.fragment_game) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val etJumlah = view.findViewById<EditText>(R.id.etJumlah)
        val btnRandom = view.findViewById<Button>(R.id.btnRandom)
        val container = view.findViewById<LinearLayout>(R.id.containerInput)


        fun buatBarisInput(nomor: Int): LinearLayout {


            val inputHukuman = EditText(requireContext()).apply {
                hint = "Hukuman ke $nomor"
                background = requireContext().getDrawable(R.drawable.edittext_bg)
                setPadding(32, 24, 32, 24)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }


            val bulatanNomor = TextView(requireContext()).apply {
                text = nomor.toString()
                textSize = 16f
                setTextColor(Color.WHITE)
                gravity = Gravity.CENTER
                background = requireContext().getDrawable(R.drawable.bg_circle)

                val diameter = 80
                layoutParams = LinearLayout.LayoutParams(diameter, diameter).apply {
                    marginEnd = 32
                }
            }


            return LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { setMargins(0, 14, 0, 14) }


                addView(bulatanNomor)
                addView(inputHukuman)
            }
        }


        etJumlah.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {


                container.removeAllViews()

                val jumlah = s.toString().toIntOrNull() ?: return
                if (jumlah <= 0) return

                for (i in 1..jumlah) {
                    val row = buatBarisInput(i)
                    container.addView(row)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        btnRandom.setOnClickListener {

            val listHukuman = mutableListOf<String>()

            // Ambil satu-satu isi edittext di setiap row
            for (i in 0 until container.childCount) {

                val row = container.getChildAt(i) as LinearLayout
                val input = row.getChildAt(1) as EditText
                val textHukuman = input.text.toString()

                if (textHukuman.isNotEmpty()) {
                    listHukuman.add(textHukuman)
                }
            }

            if (listHukuman.isEmpty()) {
                Toast.makeText(requireContext(), "Isi dulu semua hukuman!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomIndex = (0 until listHukuman.size).random()

            val intent = Intent(requireContext(), ResultActivity::class.java).apply {
                putExtra("ANGKA", randomIndex + 1)
                putExtra("HUKUMAN", listHukuman[randomIndex])
            }

            startActivity(intent)
        }
    }
}
