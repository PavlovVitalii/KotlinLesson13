package com.example.kotlinlesson13.db

import androidx.room.Room

object BookObj {

    var bookDao: BookDao

    init {
        val db = Room.databaseBuilder(App.appContext, AppDatabase::class.java, "my_books").build()
        bookDao = db.bookDao()
    }
}