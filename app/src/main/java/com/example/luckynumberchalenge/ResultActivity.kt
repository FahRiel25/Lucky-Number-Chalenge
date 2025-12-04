package com.example.luckynumberchalenge

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvAngka = findViewById<TextView>(R.id.tvAngka)
        val tvHukuman = findViewById<TextView>(R.id.tvHukuman)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val angka = intent.getIntExtra("ANGKA", 0)
        val hukuman = intent.getStringExtra("HUKUMAN")

        tvAngka.text = angka.toString()
        tvHukuman.text = hukuman ?: "-"

        btnBack.setOnClickListener {
            finish()
        }
    }
}
