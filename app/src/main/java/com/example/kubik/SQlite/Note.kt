package com.example.kubik.SQlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor

@Entity(tableName = "sqliteTest_table")
data class Note(
    @PrimaryKey var id:String,
    @ColumnInfo var mass:String ="",
    @ColumnInfo var height: String ="",
    @ColumnInfo var tablets: String ="",
    @ColumnInfo var vaksini: String ="",
    @ColumnInfo var temperature: String ="",
    @ColumnInfo var note: String =""

)