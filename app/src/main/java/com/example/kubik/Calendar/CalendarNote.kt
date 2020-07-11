package com.example.kubik.Calendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.kubik.Calendar.Model.DataBAseModel
import com.example.kubik.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CalendarNote : AppCompatActivity() {
    var key = ""
    val list = DataBAseModel().getList()
    var flag = list[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_note)
        key = intent.getStringExtra("Date")!!
        findViewById<TextView>(R.id.animal_date).text = "Событие $key"
    }

    fun addNote(view: View) {
        val param = findViewById<EditText>(R.id.animal_edit).text.toString()
        if (param != "") {
            CoroutineScope(Dispatchers.IO).launch {
                if (DataBAseModel().checkDataBase(applicationContext, key)) {
                    DataBAseModel().addItemToDataBase(flag, applicationContext, key, param)
                } else {
                    DataBAseModel().updateItemByDataBase(flag, applicationContext, key, param)
                }
            }
        }

        startActivity(Intent(this, Calendar::class.java))
    }

    fun updateEdit(flag: String) {
        findViewById<EditText>(R.id.animal_edit).text.clear()
        findViewById<EditText>(R.id.animal_edit).hint = "Введите  $flag"
    }

    fun mass(view: View) {
        flag = list[0]
        updateEdit(flag)
    }

    fun height(view: View) {
        flag = list[1]
        updateEdit(flag)
    }

    fun tablets(view: View) {
        flag = list[2]
        updateEdit(flag)
    }

    fun vaksini(view: View) {
        flag = list[3]
        updateEdit(flag)
    }

    fun temp(view: View) {
        flag = list[4]
        updateEdit(flag)
    }

    fun note(view: View) {
        flag = list[5]
        updateEdit(flag)
    }
}