package com.example.kubik.SQlite

import androidx.room.Dao
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM sqliteTest_table WHERE id =:id")
    fun getAllById(id:String): List<Note>

    @Query("UPDATE sqliteTest_table SET mass=:param WHERE id = :id")
    fun updateMass(id:String, param:String)

    @Query("UPDATE sqliteTest_table SET height=:param WHERE id = :id")
    fun updateHeight(id:String, param:String)

    @Query("UPDATE sqliteTest_table SET tablets=:param WHERE id = :id")
    fun updateTablets(id:String, param:String)

    @Query("UPDATE sqliteTest_table SET vaksini=:param WHERE id = :id")
    fun updateVaksini(id:String, param:String)

    @Query("UPDATE sqliteTest_table SET temperature = :param WHERE id = :id")
    fun updateTemp(id:String, param:String)

    @Query("UPDATE sqliteTest_table SET note=:param WHERE id = :id")
    fun updateNote(id:String, param:String)

    @Query("DELETE FROM sqliteTest_table WHERE id =:id")
    fun delete(id:String)

    @Insert
    fun insertAll(vararg users: Note)

    @Update
    fun update(user: Note)

    @Delete
    fun delete(user: Note)

    @Query("DELETE FROM sqliteTest_table")
    fun deleteAllNote()

}