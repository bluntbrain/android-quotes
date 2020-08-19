package com.ishanlakhwani.mvvmquotesapp.ui.home.quotes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.ishanlakhwani.mvvmquotesapp.data.repositories.QuotesRepository
import com.ishanlakhwani.mvvmquotesapp.util.lazyDeferred

@RequiresApi(Build.VERSION_CODES.O)
class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}