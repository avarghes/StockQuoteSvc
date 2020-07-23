package com.exchange.api.stockquotesvc.stockquote

import java.time.LocalDate
import java.util.*

object RandomStockQuoteGenerator {
    fun generate(tickerSymbol: String?): StockQuoteDTO {
        val stockQuoteDTO = StockQuoteDTO()
        val randomPrice = Random()
        val currency = Currency.getInstance("USD")
        stockQuoteDTO.closingPrice = randomPrice.nextFloat()
        stockQuoteDTO.openningPrice = randomPrice.nextFloat()
        stockQuoteDTO.currency = currency
        stockQuoteDTO.tradingDay = LocalDate.now()
        return stockQuoteDTO
    }
}