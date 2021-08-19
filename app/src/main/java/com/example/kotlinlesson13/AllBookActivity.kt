package com.example.kotlinlesson13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson13.db.Book
import com.example.kotlinlesson13.db.BookDao
import com.example.kotlinlesson13.db.BookObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllBookActivity : AppCompatActivity() {

    val db = BookObj.bookDao
    lateinit var bookList: List<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_book)

        lifecycleScope.launch(Dispatchers.IO) {
            bookList = db.getAll()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(bookListItems, bookList)


    }

    class MyAdapter(private val items: List<BookItems>, val bookList:List<Book>) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val name: TextView = view.findViewById(R.id.name_text)
            val autor: TextView = view.findViewById(R.id.autor_text)
            val year: TextView = view.findViewById(R.id.year_text)
            val description: TextView = view.findViewById(R.id.description_text)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.book_item, parent, false)
            return ViewHolder(view)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {


            items[position].apply {
                holder.name.text = bookList.get(position).name
                holder.autor.text = bookList.get(position).author
                holder.year.text = bookList.get(position).year
                holder.description.text = bookList.get(position).description
            }

        }

        override fun getItemCount() = items.size


    }

}