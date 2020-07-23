package com.exchange.api.stockquotesvc.stockquote


import com.exchange.api.stockquotesvc.stockquote.StockQuoteDTO

internal interface IStockQuoteService {
    fun pullStockQuoteByTickerId(tickerId: String?): StockQuoteDTO?
}