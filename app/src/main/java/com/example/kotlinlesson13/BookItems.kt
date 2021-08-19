package com.example.kotlinlesson13

data class BookItems(
    val name: String,
    val autor: String,
    val year: String,
    val description: String
)

var bookList = listOf<BookItems>(
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
    BookItems("Name: ", "Autor: ", "Year: ", "Description: "),
)