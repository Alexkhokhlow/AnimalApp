package com.example.kubik.Calendar.Model

import android.content.Context
import androidx.room.Room
import com.example.kubik.SQlite.Note
import com.example.kubik.SQlite.NoteDataBase

class DataBAseModel {
    private lateinit var dataBaseSave: List<Note>

    fun getList() = listOf(
        "вес",
        "рост",
        "таблетки",
        "вакцины",
        "температура",
        "записи"
    )

    fun delete(context: Context, id: String) {
        openDataBase(context).userDao().delete(id)
    }

    private fun openDataBase(context: Context): NoteDataBase = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "CalendarDataBase"
    ).fallbackToDestructiveMigration()
        .build()

    fun checkDataBase(context: Context, id: String): Boolean {
        dataBaseSave = openDataBase(context).userDao().getAllById(id)
        if (dataBaseSave.isNotEmpty()) {
            return true
        }
        return false
    }

    fun getListFromDataBase(context: Context, id: String) =
        if (checkDataBase(context, id)) {
            initDataBaseAsList(dataBaseSave)
          }else listOf()


    private fun initDataBaseAsList(dataBaseSave: List<Note>) = listOf(
        dataBaseSave[0].mass,
        dataBaseSave[0].height,
        dataBaseSave[0].tablets,
        dataBaseSave[0].vaksini,
        dataBaseSave[0].temperature,
        dataBaseSave[0].note
    )

    fun addItemToDataBase(flag: String, context: Context, key: String, param: String) {
        when (flag) {
            getList()[0] -> openDataBase(context).userDao().insertAll(Note(key, mass = param))
            getList()[1] -> openDataBase(context).userDao().insertAll(Note(key, height = param))
            getList()[2] -> openDataBase(context).userDao().insertAll(Note(key, tablets = param))
            getList()[3] -> openDataBase(context).userDao().insertAll(Note(key, vaksini = param))
            getList()[4] -> openDataBase(context).userDao()
                .insertAll(Note(key, temperature = param))
            getList()[5] -> openDataBase(context).userDao().insertAll(Note(key, note = param))
        }
    }

    fun updateItemByDataBase(flag: String, context: Context, key: String, param: String) {
        when (flag) {
            getList()[0] -> openDataBase(context).userDao().updateMass(key, param)
            getList()[1] -> openDataBase(context).userDao().updateHeight(key, param)
            getList()[2] -> openDataBase(context).userDao().updateTablets(key, param)
            getList()[3] -> openDataBase(context).userDao().updateVaksini(key, param)
            getList()[4] -> openDataBase(context).userDao().updateTemp(key, param)
            getList()[5] -> openDataBase(context).userDao().updateNote(key, param)
        }
    }


}