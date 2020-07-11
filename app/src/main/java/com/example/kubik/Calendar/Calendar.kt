package com.example.kubik.Calendar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kubik.Calendar.Model.DataBAseModel
import com.example.kubik.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun deleteView(a: LinearLayout) = a.removeAllViews()


class Calendar : AppCompatActivity() {
  private  var date = ""
  private lateinit var noteLayout: LinearLayout
  private  lateinit var calendar: CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        calendar = findViewById(R.id.calendarView)
        noteLayout = findViewById(R.id.noteLayout)
        calendar.setOnDateChangeListener { calendar, year, month, dayOfMonth ->
            date = "$dayOfMonth/$month/$year"
            initNote()
        }
    }

    private fun initNote() {
        deleteView(noteLayout)
        CoroutineScope(Dispatchers.IO).launch {
            val list = DataBAseModel().getListFromDataBase(applicationContext, date)
            if (list.isNotEmpty()) {
                for ((index, item) in list.withIndex()) {
                    if (item != "") {
                        CoroutineScope(Dispatchers.Main).launch {
                            noteLayout.addView(getNewTextView(index, item))
                        }
                    }
                }
            }

        }
    }

   @SuppressLint("SetTextI18n")
   private fun getNewTextView(index: Int, item: String): TextView {
        val textView = TextView(applicationContext)
        textView.text = "${DataBAseModel().getList()[index]}  $item "
        textView.textSize = 18.toFloat()
        textView.setPadding(4, 10, 0, 0)
        textView.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
       return textView
    }

    fun openNote(view: View) {
        val intent = Intent(
            this,
            CalendarNote::class.java
        )
        intent.putExtra("Date", date)
        startActivity(intent)
    }

    fun delete(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            DataBAseModel().delete(applicationContext, date)
            CoroutineScope(Dispatchers.Main).launch {
                deleteView(noteLayout)
            }
        }
    }
}


