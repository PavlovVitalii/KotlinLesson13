package com.example.kotlinlesson13.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Insert
    suspend fun insert(vararg book: Book)

    @Delete
    suspend fun delete(book: Book)

    @Query("DELETE FROM book")
    suspend fun removeAll()

    @Query("SELECT * FROM book")
    suspend fun getAll(): List<Book>

}