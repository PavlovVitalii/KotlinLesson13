package com.example.kotlinlesson13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson13.db.Book
import com.example.kotlinlesson13.db.BookObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllBookActivity : AppCompatActivity() {

    val db = BookObj.bookDao
    lateinit var bookList: List<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_book)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        lifecycleScope.launch(Dispatchers.IO) {
            bookList = db.getAll()
            recyclerView.adapter = MyAdapter(bookList)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration
                (this, LinearLayoutManager.VERTICAL)
        )


    }

    class MyAdapter(private val bookList: List<Book>) :
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


            bookList[position].apply {
                holder.name.text = bookList[position].name
                holder.autor.text = bookList[position].author
                holder.year.text = bookList[position].year
                holder.description.text = bookList[position].description
            }

        }

        override fun getItemCount() = bookList.size


    }

}