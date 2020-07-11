package com.example.kubik.SQlite

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 2)

abstract class NoteDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

}