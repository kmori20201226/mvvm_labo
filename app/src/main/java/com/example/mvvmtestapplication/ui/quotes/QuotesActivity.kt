package com.example.mvvmtestapplication.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtestapplication.R
import com.example.mvvmtestapplication.data.Quote
import com.example.mvvmtestapplication.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUI()
    }

    /**
     * Initialize function
     */
    private fun initializeUI() {
        val textView_quotes = findViewById<TextView>(R.id.textView_quotes)
        val button_add_quote = findViewById<Button>(R.id.button_add_quote)
        val editText_quote = findViewById<EditText>(R.id.editText_quote)
        val editText_author = findViewById<EditText>(R.id.editText_author)
        val factory = InjectorUtils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}