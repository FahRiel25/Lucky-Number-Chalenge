package com.example.luckynumberchalenge

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val hasil = intent.getStringExtra("HASIL")
        tvHasil.text = hasil

        btnBack.setOnClickListener {
            finish()
        }
    }
}
