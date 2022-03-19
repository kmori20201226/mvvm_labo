package com.example.mvvmtestapplication.utilities

import com.example.mvvmtestapplication.data.FakeDatabase
import com.example.mvvmtestapplication.data.FakeQuoteDao
import com.example.mvvmtestapplication.data.QuoteRepository
import com.example.mvvmtestapplication.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuoteViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}