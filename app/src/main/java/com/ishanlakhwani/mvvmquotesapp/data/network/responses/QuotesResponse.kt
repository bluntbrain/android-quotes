package com.ishanlakhwani.mvvmquotesapp.data.network.responses

import com.ishanlakhwani.mvvmquotesapp.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)