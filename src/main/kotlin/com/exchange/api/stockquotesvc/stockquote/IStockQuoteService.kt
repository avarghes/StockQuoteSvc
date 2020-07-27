package com.exchange.api.stockquotesvc.stockquote


internal interface IStockQuoteService {
    fun pullStockQuoteByTickerId(tickerId: String): StockQuoteDTO?
}