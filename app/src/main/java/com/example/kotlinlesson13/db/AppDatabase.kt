package com.example.kotlinlesson13.db

import androidx.room.RoomDatabase

abstract class AppDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}