package com.example.kubik

import java.util.Calendar


class Controller() {
    fun getDaysAfterBirth():String {
       val a = Calendar.getInstance()
        a.set(2020,4,25)
        val b = Calendar.getInstance().timeInMillis
        val c = ((b - a.timeInMillis)/(1000*60*60*24)).toString();
        return c
    }

}
