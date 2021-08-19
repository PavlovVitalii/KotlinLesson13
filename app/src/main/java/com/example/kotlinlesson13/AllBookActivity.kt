package com.example.kotlinlesson13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson13.db.BookDao

class AllBookActivity : AppCompatActivity() {

    lateinit var bookDao: BookDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_book)


    }

    class MyAdapter(private val items: List<BookItems>) :
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
                holder.name.text = name
                holder.autor.text = autor
                holder.year.text = year
                holder.description.text = description
            }

        }

        override fun getItemCount() = items.size


    }
}