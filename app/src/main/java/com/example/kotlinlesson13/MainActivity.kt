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
import com.example.kotlinlesson13.db.BooksFactory
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

        lifecycleScope.launch(Dispatchers.IO) {
            val books = db.getAll()
            if (books.size == 0) {
                for (el in BooksFactory().createBooks()) {
                    db.insert(el)
                }
            }
        }
        findViewById<EditText>(R.id.descriptionView).setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {

                    name = findViewById<EditText>(R.id.nameView).text.toString()
                    autor = findViewById<EditText>(R.id.autorView).text.toString()
                    year = findViewById<EditText>(R.id.yeraView).text.toString()
                    description = findViewById<EditText>(R.id.descriptionView).text.toString()


                    lifecycleScope.launch(Dispatchers.IO) {
                        db.insert(Book(name, autor, year, description))
                    }
                    findViewById<EditText>(R.id.nameView).text.clear()
                    findViewById<EditText>(R.id.autorView).text.clear()
                    findViewById<EditText>(R.id.yeraView).text.clear()
                    findViewById<EditText>(R.id.descriptionView).text.clear()

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
            startActivity(Intent(this, AllBookActivity::class.java))
        }
    }


}
