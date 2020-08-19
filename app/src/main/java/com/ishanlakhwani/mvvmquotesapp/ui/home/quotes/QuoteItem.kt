package com.ishanlakhwani.mvvmquotesapp.ui.home.quotes

import com.xwray.groupie.databinding.BindableItem
import com.ishanlakhwani.mvvmquotesapp.R
import com.ishanlakhwani.mvvmquotesapp.data.db.entities.Quote
import com.ishanlakhwani.mvvmquotesapp.databinding.ItemQuoteBinding

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}