package com.example.mvvmtestapplication.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmtestapplication.data.Quote
import com.example.mvvmtestapplication.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}