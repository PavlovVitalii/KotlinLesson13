package com.example.kotlinlesson13

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlinlesson13.db.Book
import com.example.kotlinlesson13.db.BookObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // lateinit var bookDao: BookDao
    lateinit var name: String
    lateinit var autor: String
    lateinit var year: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = BookObj.bookDao

        findViewById<EditText>(R.id.descriptionView).setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {

                    name = findViewById<EditText>(R.id.nameView).text.toString()
                    autor = findViewById<EditText>(R.id.autorView).text.toString()
                    year = findViewById<EditText>(R.id.yeraView).text.toString()
                    description = findViewById<EditText>(R.id.descriptionView).text.toString()
//                    val listBook = listOf<Book>(
//                        Book("a", "a", "a", "a"),
//                        Book("b", "b", "b", "b"),
//                        Book("c", "c", "c", "c"),
//                        Book("d", "d", "d", "d")
//                    )

                    lifecycleScope.launch(Dispatchers.IO) {
                        db.insert(Book(name, autor, year, description))
                    }

                    true
                }
                else -> false
            }
        }

        val button = findViewById<Button>(R.id.clear_button)
        button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.removeAll()
            }
        }

        val button_2 = findViewById<Button>(R.id.load_button)
        button_2.setOnClickListener {
            startActivity(Intent(this,AllBookActivity::class.java))
        }
    }

}