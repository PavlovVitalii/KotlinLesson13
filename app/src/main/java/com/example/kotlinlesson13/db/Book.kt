package com.example.kotlinlesson13.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(

    val name: String,
    val author: String,
    val year: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
