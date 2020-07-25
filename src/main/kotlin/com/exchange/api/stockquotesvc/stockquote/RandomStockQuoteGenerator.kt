package com.exchange.api.stockquotesvc.stockquote

import java.time.LocalDate
import java.util.*

object RandomStockQuoteGenerator {
    fun generate(tickerSymbol: String?): StockQuoteDTO {
        val randomPrice = Random()
        val stockQuoteDTO = StockQuoteDTO(currency = Currency.getInstance("USD"),
                closingPrice = randomPrice.nextFloat(),
                openningPrice = randomPrice.nextFloat(), tradingDay = LocalDate.now(),listedExchange = "NASDAQ")
        return stockQuoteDTO
    }
}