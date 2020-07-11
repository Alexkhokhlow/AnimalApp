package com.example.kubik.Avto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kubik.R

class Avto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avto)
        findViewById<TextView>(R.id.noteAvto).text = Controller().getAvto()
    }
}