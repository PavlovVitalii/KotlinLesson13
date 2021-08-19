package com.example.kotlinlesson13

data class BookItems(
    val name: String,
    val autor: String,
    val year: String,
    val description: String
)

var bookListItems = listOf(
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