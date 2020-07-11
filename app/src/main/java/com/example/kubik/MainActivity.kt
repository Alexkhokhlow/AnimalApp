package com.example.kubik

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kubik.Avto.Avto
import com.example.kubik.Calendar.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.days_after_birth).text = Controller().getDaysAfterBirth()
    }

    fun openCalendar(view: View) {
        val intent = Intent(this, Calendar::class.java)
        startActivity(intent)
    }
}