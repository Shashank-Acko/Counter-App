package com.example.counter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0

        val btnIn = findViewById<Button>(R.id.btnIncrease)
        val btnDec = findViewById<Button>(R.id.btnDecrease)
        val txtview = findViewById<TextView>(R.id.textView)

        val positive = findViewById<Switch>(R.id.restrict)

        positive.setOnClickListener {
            if(counter < 0) {
                counter = 0
                txtview.text = "$counter"
            }
        }

        btnIn.setOnClickListener {
            counter += 1
            txtview.text = "$counter"

//            Toast.makeText(this, "This is a test", Toast.LENGTH_LONG).show()
        }

        btnDec.setOnClickListener {
            var state = positive.isChecked

            if(state && counter <= 0) {
                Toast.makeText(this, "Restricted negative values.", Toast.LENGTH_LONG).show()
            } else {
                counter -= 1
                txtview.text = "$counter"
            }
        }
    }
}